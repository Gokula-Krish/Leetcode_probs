class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        TreeMap<String,ArrayList<String>> map=new TreeMap();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String s1=new String(ch);
            if(!map.containsKey(new String(ch))){
                map.put(s1,new ArrayList());
                map.get(s1).add(s);
            }
            else{
                map.get(s1).add(s);
            }
        }
        List<List<String>> ls=new ArrayList();
        for(Map.Entry m:map.entrySet()){
            ls.add((ArrayList)m.getValue());
          //  System.out.println(m.getValue());
        }
        return ls;
    }
}