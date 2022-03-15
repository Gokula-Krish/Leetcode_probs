class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] c=nums.clone();
        Arrays.sort(c);
        int len=Integer.MAX_VALUE;
        int l=-1,r=-1;
        for(int i=0;i<nums.length;i++){
            if(c[i]!=nums[i]){
                l=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(c[i]!=nums[i]){
                r=i;
                break;
            }
        }
        return r-l<=0?0:r-l+1;
    }
}