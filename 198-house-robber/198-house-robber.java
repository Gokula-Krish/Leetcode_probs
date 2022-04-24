class Solution {
    public int rob(int[] nums) {
        int rob1=0,rob2=0,t;
        for(int i:nums){
            t=Math.max(i+rob1,rob2);
            rob1=rob2;
            rob2=t;
        }
        return rob2;
    }
}