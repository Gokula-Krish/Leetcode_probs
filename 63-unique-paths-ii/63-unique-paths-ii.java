class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return recurse(obstacleGrid,new boolean[obstacleGrid.length][obstacleGrid[0].length],0,0,dp);
    }
    public int recurse(int[][] A,boolean[][] visited,int r,int c,int[][] dp){
        if(r<0 || c<0 || r>=A.length || c>=A[0].length || visited[r][c] || A[r][c]==1){
            return 0;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        if(r==A.length-1 && c==A[0].length-1){
            return 1;
        }
        visited[r][c]=true;
        int right=recurse(A,visited,r,c+1,dp);
        int down=recurse(A,visited,r+1,c,dp);
        visited[r][c]=false;
        return dp[r][c]=right+down;
    }
}