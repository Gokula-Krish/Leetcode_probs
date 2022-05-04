class Solution {
    public int maxOperations(int[] nums, int k) {
        int c=0;
        HashMap<Integer,Integer> map=new HashMap();
        for(int i:nums){
            int s=k-i;
            if(map.containsKey(s)){
                c++;
                map.put(s,map.get(s)-1);
                if(map.get(s)==0){
                    map.remove(s);
                }
            }
            else{
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        return c;
    }
}