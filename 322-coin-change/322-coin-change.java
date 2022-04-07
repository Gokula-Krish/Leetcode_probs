class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(j==0){
                    dp[i][j]=0;
                }
                else if(i==0){
                    dp[i][j]=999999;
                }
                else if(j<coins[i-1]){
                   dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
                }
            }
        }
        int ans=dp[coins.length][amount];
        return ans==999999?-1:ans;
    }
}