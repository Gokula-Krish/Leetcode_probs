class Solution {
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
    public int search(int[] nums, int target) {
        if(nums.length==1){
            if(nums[0]==target){
                return 0;
            }
            else{
                return -1;
            }
        }
        int pivotIndex=findPivot(nums);
        if(pivotIndex==-1){
            return binarySearch(nums,target,0,nums.length-1);
        }
        //System.out.println(nums[pivotIndex]);
        if(nums[pivotIndex]==target){
            return pivotIndex;
        }
        else if(target>=nums[0]){
            return binarySearch(nums,target,0,pivotIndex-1);
        }
        return binarySearch(nums,target,pivotIndex+1,nums.length-1); 
    }
    public int binarySearch(int[] nums,int t,int l,int r){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==t){
                return mid;
            }
            else if(nums[mid]>t){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
}