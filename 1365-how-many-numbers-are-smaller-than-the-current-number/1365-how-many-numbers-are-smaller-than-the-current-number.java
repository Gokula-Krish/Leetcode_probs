class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans=new int[nums.length];
        TreeMap<Integer,Integer> map=new TreeMap();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int prev=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int k=m.getValue();
            map.put(m.getKey(),prev);
            prev+=k;
        }
        int k=0;
        for(int a:nums){
            ans[k++]=map.get(a);
        }
        return ans;
    }
}