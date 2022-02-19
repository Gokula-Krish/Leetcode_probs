class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return nonAdjacentSum(0,nums,n-1,dp);
    }
    public int nonAdjacentSum(int start,int[] nums,int i,int[] dp){
        if(i==start){
            return nums[i];
        }
        if(i<0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int a=nums[i]+nonAdjacentSum(start,nums,i-2,dp);
        int b=nonAdjacentSum(start,nums,i-1,dp);
        return dp[i]=Math.max(a,b);
    }
}