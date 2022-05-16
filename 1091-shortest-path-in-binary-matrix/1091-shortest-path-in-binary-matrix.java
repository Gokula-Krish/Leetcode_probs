class Solution {
    public boolean isValid(int[][] grid,boolean[][] visited,int r,int c,int n){    
        return (r>=0 && c>=0 && r<n && c<n && !visited[r][c] && grid[r][c]==0);
    }
    int[] row={-1,1,0,0,-1,-1,1,1};
    int[] col={0,0,-1,1,1,-1,1,-1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1){
            return -1;
        }
        boolean[][] visited=new boolean[n][n];
        Queue<int[]> q=new LinkedList();
        q.add(new int[]{0,0,1});
        visited[0][0]=true;
        while(!q.isEmpty()){
            int[] pair=q.poll();
            if(pair[0]==n-1 && pair[1]==n-1){
                return pair[2];
            }
            for(int i=0;i<8;i++){
                int pX=pair[0]+row[i];
                int pY=pair[1]+col[i];
                if(isValid(grid,visited,pX,pY,n)){     
                    q.add(new int[]{pX,pY,pair[2]+1});
                    visited[pX][pY]=true;
                }
            }
        }
        return -1;
    }
}