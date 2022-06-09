class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int min=nums[0],max=nums[0],ans=max;
        for(int i=1;i<n;i++){
            int c1=min*nums[i];
            int c2=max*nums[i];
            max=Math.max(nums[i],Math.max(c1,c2));
            min=Math.min(nums[i],Math.min(c1,c2));
            ans=Math.max(ans,max);
        }
        return ans;   
    }
}