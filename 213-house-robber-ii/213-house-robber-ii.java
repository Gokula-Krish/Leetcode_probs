class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int a=nonAdjacentSum(1,n-1,nums,dp);
        Arrays.fill(dp,-1);
        int b=nonAdjacentSum(0,n-2,nums,dp);
        return Math.max(a,b);
    }
    public int nonAdjacentSum(int start,int i,int[] nums,int[] dp){
        if(i==start){
            return nums[i];
        }
        if(i<start){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int a=nums[i]+nonAdjacentSum(start,i-2,nums,dp);
        int b=nonAdjacentSum(start,i-1,nums,dp);
        return dp[i]=Math.max(a,b);
    }
}