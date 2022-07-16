class Solution {
    public void solve(char[][] board) {
        boolean[][] safe=new boolean[board.length][board[0].length];
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                bfs(0,i,board);
            }
            if(board[board.length-1][i]=='O'){
                bfs(board.length-1,i,board);
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                bfs(i,0,board);
            }
            if(board[i][board[0].length-1]=='O'){
                bfs(i,board[0].length-1,board);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='S'){
                    board[i][j]='O';
                }
            }
        }
    }

    public void bfs(int k,int j,char[][] board){
        boolean[][] visited=new boolean[board.length][board[0].length];
        Queue<int[]> q=new LinkedList();
        int[] row={-1,1,0,0};
        int[] col={0,0,-1,1};
        q.add(new int[]{k,j});
        visited[k][j]=true;
        board[k][j]='S';
        while(!q.isEmpty()){
            int[] pair=q.poll();
            for(int i=0;i<4;i++){
                int pX=pair[0]+row[i];
                int pY=pair[1]+col[i];
                if(isValid(pX,pY,board,visited)){
                    board[pX][pY]='S';
                    q.add(new int[]{pX,pY});
                    visited[pX][pY]=true;
                }
            }
        }
    }
    public boolean isValid(int r,int c,char[][] A,boolean[][] visited){
        return r>=0 && c>=0 && r<A.length && c<A[0].length && !visited[r][c] && A[r][c]=='O';
    }
}