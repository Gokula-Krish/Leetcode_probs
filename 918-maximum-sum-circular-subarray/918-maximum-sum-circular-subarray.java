class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        int max=nums[0],max1=nums[0],min=nums[0],min1=nums[0];
        for(int i=1;i<nums.length;i++){
            max=Math.max(max+nums[i],nums[i]);
            max1=Math.max(max,max1);
            min=Math.min(min+nums[i],nums[i]);
            min1=Math.min(min,min1); 
        }
        if(min1==sum){
            return max1;
        }
        return Math.max(max1,sum-min1);
    }
}