class Solution {
    public int LIS(int[] nums,int j,int prev,int[][] dp){
        if(j==nums.length){
            return 0;
        }
        if(prev!=-1 && dp[prev][j]!=-1){
            return dp[prev][j];
        }
        int len=0;
        if(prev==-1 || nums[j]>nums[prev]){
            len=1+Math.max(len,LIS(nums,j+1,j,dp));
        }
        len=Math.max(len,LIS(nums,j+1,prev,dp));
        if(prev!=-1)
            dp[prev][j]=len;
        return len;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] LIS=new int[n];
        for(int i=n-1;i>=0;i--){
            LIS[i]=1;
            for(int j=i+1;j<n;j++){
                if(nums[i]<nums[j]){
                    LIS[i]=Math.max(LIS[i],1+LIS[j]);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i:LIS){
            max=Math.max(max,i);
        }
        return max;   
    }
}