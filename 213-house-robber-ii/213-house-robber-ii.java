class Solution {
    public int houseRob1(int[] nums){
        int rob1=0,rob2=0,t;
        for(int i:nums){
            t=Math.max(i+rob1,rob2);
            rob1=rob2;
            rob2=t;
        }
        return rob2;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        return Math.max(houseRob1(Arrays.copyOfRange(nums,0,n-1)),houseRob1(Arrays.copyOfRange(nums,1,n)));
    }
}