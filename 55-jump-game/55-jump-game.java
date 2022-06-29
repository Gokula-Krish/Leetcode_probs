class Solution {
    public boolean canJump(int[] nums) {
        int far=nums[0];
        for(int i=1;i<nums.length;i++){
            if(far<i){
                return false;
            }
            far=Math.max(far,i+nums[i]);
        }
        return true;
    }
}