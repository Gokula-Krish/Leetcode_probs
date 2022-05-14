class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list=new ArrayList();
        if(s.length()<10){
            return list;
        }
        HashMap<String,Integer> map=new HashMap();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append(s.charAt(i));
        }
        map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        for(int i=10;i<s.length();i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }
        for(Map.Entry<String,Integer> set:map.entrySet()){
            if(set.getValue()>1){
                list.add(set.getKey());
            }
        }
        return list;
    }
}