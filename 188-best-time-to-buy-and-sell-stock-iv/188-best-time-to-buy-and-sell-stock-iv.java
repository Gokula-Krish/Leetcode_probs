class Solution {
    public int buyAndSell(int[] prices,int[][][] dp,int ind,int buy,int cap,int n){
        if(cap==0){
            return 0;
        }
        if(ind==n){
            return 0;
        }
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap];
        }
        if(buy==1){
            return dp[ind][buy][cap]=Math.max(-prices[ind]+buyAndSell(prices,dp,ind+1,0,cap,n),
                                    buyAndSell(prices,dp,ind+1,1,cap,n));
        }
        return dp[ind][buy][cap]=Math.max(prices[ind]+buyAndSell(prices,dp,ind+1,1,cap-1,n),
                                    buyAndSell(prices,dp,ind+1,0,cap,n));
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for(int[][] d1:dp){
            for(int[] a:d1){
                Arrays.fill(a,-1);
            }
        }
        return buyAndSell(prices,dp,0,1,k,n);
    }
}