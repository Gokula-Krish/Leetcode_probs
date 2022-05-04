class Solution {
    public int maxOperations(int[] nums, int k) {
        int c=0;
        HashMap<Integer,Integer> map=new HashMap();
        for(int i:nums){
            int s=k-i;
            if(map.containsKey(s) && map.get(s)>0){
                c++;
                map.put(s,map.get(s)-1);
            }
            else{
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        return c;
    }
}