class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean change=false;
        int n=nums.length;
        if(n>=2 && nums[0]>nums[1]){
            nums[0]=nums[1];
            change=true;
        }
        for(int i=2;i<n;i++){
            if(nums[i]<nums[i-1] && nums[i-2]>nums[i]){
                if(change){return false;}
                nums[i]=nums[i-1];
                change=true;
            }
            else if(nums[i]<nums[i-1] && nums[i-2]<=nums[i]){
                if(change){return false;}
                nums[i-1]=nums[i];
                change=true;
            }
        }
        return true;
    }
}