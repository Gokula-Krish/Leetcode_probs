class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int n=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(grid,i,j,visited);
                    n++;
                }
            }
        }
        return n;
    }
    public void dfs(char[][] A,int i,int j,boolean[][] visited){
        if(i<0 || j<0 || i>=A.length || j>=A[0].length || A[i][j]=='0' || visited[i][j]){
            return;
        }
        visited[i][j]=true;
        dfs(A,i-1,j,visited);
        dfs(A,i+1,j,visited);
        dfs(A,i,j+1,visited);
        dfs(A,i,j-1,visited);
    }
}