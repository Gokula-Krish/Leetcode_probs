class Solution {
    int c=0;
    HashMap<Integer,Integer> map=new HashMap();
    public int findTargetSumWays(int[] nums, int target) {
        return recursion(nums,target,0);
    }
    public int recursion(int[] nums,int target,int i){
        // if(map.containsKey(target)){
        //     return map.get(target);
        // }
        if(i==nums.length){
            if(target==0){
                return 1;
            }
            return 0;
        }
        int a=recursion(nums,target+nums[i],i+1);
        int b=recursion(nums,target-nums[i],i+1);
       // map.put(target,(a+b));
        return a+b;
    }
}