class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        int ans=0;
        for(int i=0;i<matrix[0].length;i++){
            dp[0][i]=matrix[0][i]-'0';
            if(dp[0][i]==1){ans=1;}
        }
        for(int i=0;i<matrix.length;i++){
            dp[i][0]=matrix[i][0]-'0';
            if(dp[i][0]==1){ans=1;}
        }
        int max=0;
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                  ans=1;
                  dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        int sq=max*max;
        return sq==0?ans:sq;
    }
}