class Solution {
    HashMap<Integer,Integer> memo=new HashMap();
    public int recursion(int target,int[] arr){
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target<0){
            return 0;
        }
        if(target==0){
            return 1;
        }
        int c=0;
        for(int i=0;i<arr.length;i++){
             c+=recursion(target-arr[i],arr);
             memo.put(target,c);
        }
        return c;
    }
    public int combinationSum4(int[] nums, int target) {
        return recursion(target,nums);
    }
}