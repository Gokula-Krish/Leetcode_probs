class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,visited,i,j);
                    return res;
                }
            }
        }
        return 0;
    }
    int res=0;
    public int dfs(int[][] A,boolean[][] visited,int r,int c){
        if(r<0 || c<0 || r>=A.length || c>=A[0].length || A[r][c]==0){
            return 0;
        }
        if(visited[r][c]){
            return 1;
        }
        visited[r][c]=true;
        int w=dfs(A,visited,r-1,c);
        int x=dfs(A,visited,r+1,c);
        int y=dfs(A,visited,r,c-1);
        int z=dfs(A,visited,r,c+1);
        res+=(w==0?1:0)+(x==0?1:0)+(y==0?1:0)+(z==0?1:0);
        return -1;
    }
}