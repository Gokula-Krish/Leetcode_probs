class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet();
        int min=Integer.MAX_VALUE;
        for(int i:nums){
            min=Math.min(min,i);
            set.add(i);
        }
        if(min>1){
            return 1;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int e=nums[i]+1;
            if(nums[i]<0){
                if(!set.contains(1)){
                    return 1;
                }
            }
            if(e!=0 && e>0){
                if(!set.contains(e)){
                    ans=Math.min(e,ans);
                }
            }
        }
        return ans;
    }
}