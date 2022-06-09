class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        while(l<r){
            int sum=numbers[l]+numbers[r];
            if(sum==target){
                int[] ans={l+1,r+1};
                return ans;
            }
            else if(sum<target){
                l++;
            }
            else{
                r--;
            }
        }
        int[] ans={-1,-1};
        return ans;
    }
}