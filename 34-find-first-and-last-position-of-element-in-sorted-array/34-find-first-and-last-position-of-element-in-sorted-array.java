class Solution {
    int findFirst(int[] nums,int target){
        int l=0,r=nums.length-1,res=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                res=mid;r=mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return res;
    }
    int findLast(int[] nums,int target){
        int l=0,r=nums.length-1,res=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                res=mid;l=mid+1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums,target),findLast(nums,target)};
    }
}