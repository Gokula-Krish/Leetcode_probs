class Solution {
    public int findMin(int[] nums) {
        int pIndex=findPivot(nums);
        if(pIndex==-1){
            return nums[0];
        }
        return Math.min(nums[pIndex+1],nums[0]);
    }
    public int findPivot(int[] nums){
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid<r && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid>l && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[l]>=nums[mid]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
}