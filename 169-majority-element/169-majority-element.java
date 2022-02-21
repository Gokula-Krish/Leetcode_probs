class Solution {
    public int majorityElement(int[] nums) {
        LinkedHashMap<Integer,Integer> lh=new LinkedHashMap();
        for(int i:nums){
            lh.put(i,lh.getOrDefault(i,0)+1);
        }
        int n=nums.length;
        for(Map.Entry m:lh.entrySet()){
            if((int)m.getValue()>(n/2)){
                return (int)m.getKey();
            }
        }
        return 0;
    }
}