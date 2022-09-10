class Solution {
    public int buy(int[] A,int[][][] dp,int buy,int i,int cap,int n){
        if(cap==0)return 0;
        if(i==n)return 0;
        if(dp[i][buy][cap]!=-1){
            return dp[i][buy][cap];
        }
        if(buy==1){
            return dp[i][buy][cap]=Math.max(-A[i]+buy(A,dp,0,i+1,cap,n),
                                    buy(A,dp,1,i+1,cap,n));
        }
        return dp[i][buy][cap]=Math.max(A[i]+buy(A,dp,1,i+1,cap-1,n),
                                buy(A,dp,0,i+1,cap,n));
    }
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length][2][3];
        for(int[][] A:dp){
            for(int[] d:A){
                Arrays.fill(d,-1);
            }
        }
        return buy(prices,dp,1,0,2,prices.length);
    }
}