class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);           
        }
        int len=0;
        for(int i:nums){
            if(map.containsKey(i-1)){
                len=Math.max(map.get(i)+map.get(i-1),len);
            }
            if(map.containsKey(i+1)){
                len=Math.max(map.get(i)+map.get(i+1),len);
            }
        }
        return len;
    }
}