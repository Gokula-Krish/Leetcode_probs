class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr=nums.clone();
        Arrays.sort(arr);
        int l=0,r=nums.length-1;
        boolean left=false,right=false;
        int s=-1,e=-1;
        while(l<r){
            if(nums[l]!=arr[l] && s==-1){
                s=l;
            }
            if(nums[r]!=arr[r] && e==-1){
                e=r;
            }   
            if(s!=-1 && e!=-1){
                break;
            }
            l=(s==-1)?++l:l;
            r=(e==-1)?--r:r;
        }
        return e-s<=0?0:(e-s)+1;
    }
}