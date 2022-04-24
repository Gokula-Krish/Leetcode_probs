class Solution {
    public List<Integer> findLonely(int[] nums) {
        ArrayList<Integer> ls=new ArrayList();
        HashMap<Integer,Integer> map=new HashMap();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:nums){
            if(map.containsKey(i-1) || map.containsKey(i+1) || (map.containsKey(i) && map.get(i)>1)){}
            else{
                ls.add(i);
            }
        }
        return ls;
    }
}