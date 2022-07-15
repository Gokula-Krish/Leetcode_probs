class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    max=Math.max(max,dfs(grid,i,j,visited));
                }
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
    public int dfs(int[][] A,int i,int j,boolean[][] visited){
        if(i<0 || j<0 || i>=A.length || j>=A[0].length || visited[i][j] || A[i][j]==0){
            return 0;
        }
        visited[i][j]=true;
        int top=dfs(A,i-1,j,visited);
        int bottom=dfs(A,i+1,j,visited);
        int left=dfs(A,i,j-1,visited);
        int right=dfs(A,i,j+1,visited);
        return 1+top+bottom+left+right;
    }
}