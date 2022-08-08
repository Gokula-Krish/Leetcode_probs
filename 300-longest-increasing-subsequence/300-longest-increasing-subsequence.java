class Solution {
    public int LIS(int[] nums,int j,int prev,int[][] dp){
        if(j==nums.length){
            return 0;
        }
        if(dp[prev+1][j]!=-1){
          //  System.out.println(prev+"----"+j+"---"+dp[prev+1][j]);
            return dp[prev+1][j];
        }
        int len=0;
        if(prev==-1 || nums[j]>nums[prev]){
            len=1+Math.max(len,LIS(nums,j+1,j,dp));
        }
        len=Math.max(len,LIS(nums,j+1,prev,dp));
        dp[prev+1][j]=len;
        return len;
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return LIS(nums,0,-1,dp);   
    }
}