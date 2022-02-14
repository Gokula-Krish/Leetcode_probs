class Solution {
    public int countBattleships(char[][] board) {
        int res=0;
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(!visited[i][j] && board[i][j]=='X'){
                    dfs(board,visited,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] A,boolean[][] visited,int r,int c){
        if(r<0 || c<0 || r>=A.length || c>=A[0].length || A[r][c]=='.' || visited[r][c]){
            return;
        }
        visited[r][c]=true;
        dfs(A,visited,r-1,c);
        dfs(A,visited,r+1,c);
        dfs(A,visited,r,c-1);
        dfs(A,visited,r,c+1);
    }
}