class Solution {
    int c=0;
    public int findTargetSumWays(int[] nums, int target) {
        recursion(nums,target,0);
        return c;
    }
    public void recursion(int[] nums,int target,int i){
        if(i==nums.length){
            if(target==0){
                c++;
                return;
            }
        }
        else{
            recursion(nums,target+nums[i],i+1);
            recursion(nums,target-nums[i],i+1);
        }
    }
}