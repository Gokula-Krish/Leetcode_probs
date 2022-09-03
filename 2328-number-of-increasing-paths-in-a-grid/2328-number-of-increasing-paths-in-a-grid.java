class Solution {
   // long count=0;
     int mod = (int) 1e9+7;
    public int dfs(int[][] A,int r,int c,int[][] dp){
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        if(r<0 || c<0 || r>=A.length || c>=A[0].length){
            return 0;
        }
        int count=0;
        if(r<A.length-1 && A[r][c]<A[r+1][c]){
            count+=1+dfs(A,r+1,c,dp);
        }
        if(r>0 && A[r][c]<A[r-1][c]){
            count+=1+dfs(A,r-1,c,dp);
        }
        if(c<A[0].length-1 && A[r][c]<A[r][c+1]){
            count+=1+dfs(A,r,c+1,dp);
        }
        if(c>0 && A[r][c]<A[r][c-1]){
            count+=1+dfs(A,r,c-1,dp);
        }
        dp[r][c]=count%mod;
        return dp[r][c];
    }
    public int countPaths(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                c+=1+dfs(grid,i,j,dp);
                c%=mod;
            }
        }
        return c%mod;
    }
}