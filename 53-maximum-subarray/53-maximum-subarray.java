class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int s1=nums[0],s=nums[0];
        for(int i=1;i<nums.length;i++){
            s1=Math.max(nums[i],s1+nums[i]);
            s=Math.max(s,s1);
        }
        return s;
    }
}