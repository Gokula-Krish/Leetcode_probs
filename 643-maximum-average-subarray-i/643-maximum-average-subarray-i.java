class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        int n=nums.length;
        int j=0;
        double max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(i<k){
                sum+=nums[i];
            }
            if(i==k-1){
                  max=Math.max(max,sum/k);
            }
            if(i>=k){
                sum+=nums[i]-nums[j++];
                max=Math.max(max,sum/k);
            }
        }
        return max;
    }
}