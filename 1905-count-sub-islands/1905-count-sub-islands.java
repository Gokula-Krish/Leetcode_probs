class Solution {
    boolean find=false;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean[][] visited=new boolean[grid1.length][grid1[0].length];
        int ans=0;
        for(int i=0;i<grid1.length;i++){
            for(int j=0;j<grid1[0].length;j++){
                if(!visited[i][j] && grid2[i][j]==1){
                    find=true;
                    dfs(i,j,grid1,grid2,visited);
                    if(find){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public void dfs(int r,int c,int[][] A,int[][] B,boolean[][] visited){
        if(r<0 || c<0 || r>=A.length || c>=A[0].length || B[r][c]==0 
          || visited[r][c]){
            return;
        }
        if(A[r][c]==0 && B[r][c]==1){
            find=false;
        }
        visited[r][c]=true;
        dfs(r+1,c,A,B,visited);
        dfs(r,c+1,A,B,visited);
        dfs(r,c-1,A,B,visited);
        dfs(r-1,c,A,B,visited);
    }
}