class Solution {
    public int jump(int[] nums) {
        int c=0,n=nums.length,l=0,r=0;
        while(r<n-1){
            int far=0;
            for(int i=l;i<r+1;i++){
                far=Math.max(i+nums[i],far);
            }
            c++;
            l=r+1;
            r=far;
        }
        return c;
    }
}