class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr=nums.clone();
        Arrays.sort(arr);
        int l=0,r=nums.length-1;
        boolean left=false,right=false;
        while(l<r){
            if(nums[l]!=arr[l]){
                left=true;
            }
            if(nums[r]!=arr[r]){
                right=true;
            }
            if(!left){
                l++;
            }
            if(!right){
                r--;
            }
            if(left && right){
                break;
            }
        }
        return r-l==0?0:(r-l)+1;
    }
}