class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap();
        HashMap<Integer,Integer> map1=new HashMap();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        HashSet<Integer> set=new HashSet();
        for(int i:nums){
            if(map.get(i)==0)continue;
            if(map1.getOrDefault(i,0)>0){
                map1.put(i,map1.get(i)-1);
                map.put(i,map.get(i)-1);
                map1.put(i+1,map1.getOrDefault(i+1,0)+1);
            }
            else if(map.get(i)>0 && map.getOrDefault(i+1,0)>0 && map.getOrDefault(i+2,0)>0){
                map.put(i,map.get(i)-1);
                map.put(i+1,map.get(i+1)-1);
                map.put(i+2,map.get(i+2)-1);
                map1.put(i+3,map1.getOrDefault(i+3,0)+1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}