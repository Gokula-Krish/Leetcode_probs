class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int j=i+1,k=nums.length-1;
            while(j<k){
                int d=nums[j]-nums[i],d1=nums[k]-nums[j];
                if(d==diff && d1==diff){
                    count++;
                    break;
                }
                else if(d<diff){
                    j++;
                }
                else if(d1>diff){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return count;
    }
}