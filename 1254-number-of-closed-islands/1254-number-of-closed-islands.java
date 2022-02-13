class Solution {
    public int closedIsland(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(!visited[i][j] && grid[i][j]==0){
                    if(dfs(grid,visited,i,j)){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    public boolean dfs(int[][] A,boolean[][] visited,int r,int c){
        if(r<0 || c<0 || r>=A.length || c>=A[0].length){
            return false;
        }
        if(A[r][c]==1 || visited[r][c]){
            return true;
        }
        visited[r][c]=true;
        boolean w=dfs(A,visited,r-1,c);
        boolean x=dfs(A,visited,r+1,c);
        boolean y=dfs(A,visited,r,c-1);
        boolean z=dfs(A,visited,r,c+1);
        return w && x && y && z;
    }
}