class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int m=1,c=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                if((1+nums[i])==nums[i+1]){
                    c++;
                }
                else{
                    m=Math.max(m,c);
                    c=1;
                }
            }
        }
        return Math.max(m,c);
    }
}