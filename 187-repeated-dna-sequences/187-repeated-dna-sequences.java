class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list=new ArrayList();
        HashMap<String,Integer> map=new HashMap();
        for(int i=0;i<=s.length()-10;i++){
            String str=s.substring(i,i+10);
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String,Integer> set:map.entrySet()){
            if(set.getValue()>1){
                list.add(set.getKey());
            }
        }
        return list;
    }
}