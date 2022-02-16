class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        int sum1=0,sum2=0;
        for(int i=0;i<nums.length;i++){
            int t=sum;  
            sum2=t-sum1-nums[i];
            if(sum1==sum2){
                return i;
            }
            sum1+=nums[i];
        }
        return -1;
    }
}