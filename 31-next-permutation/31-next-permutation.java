class Solution {
    public void nextPermutation(int[] nums) {
        int k=-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                k=i;
            }
        }
        if(k==-1){
            Arrays.sort(nums);
            return;
        }
        int l=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[k]<nums[i] && i>k){
                l=i;
            }
        }
        int t=nums[l];
        nums[l]=nums[k];
        nums[k]=t;
        int s=k+1,e=nums.length-1;
        while(s<e){
            t=nums[s];
            nums[s]=nums[e];
            nums[e]=t;
            s++;e--;
        }
    }
}