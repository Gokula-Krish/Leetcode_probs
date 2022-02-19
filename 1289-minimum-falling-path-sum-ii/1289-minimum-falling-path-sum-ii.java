class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        if(n==1){
            return grid[0][0];
        }
        int[][] dp=new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,dfs(grid,0,i,dp,n,new boolean[n][n]));
        }
        return min;
    }
    int dfs(int[][] A,int r,int c,int[][] dp,int n,boolean[][] visited){
        if(r==n){
            return 0;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int m=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(i==c){continue;}
            int z=dfs(A,r+1,i,dp,n,visited);
            m=Math.min(m,z);
        }
        if(m!=Integer.MAX_VALUE){
            dp[r][c]=A[r][c]+m;
        }
        return dp[r][c];
    }
}