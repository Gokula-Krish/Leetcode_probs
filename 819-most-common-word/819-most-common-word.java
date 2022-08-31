class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph=paragraph.toLowerCase();
        List<String> list=new LinkedList();
        StringBuilder sb=new StringBuilder();
        HashSet<String> set=new HashSet();
        HashMap<String,Integer> map=new HashMap();
        for(String s:banned){
            set.add(s);
        }
        for(char c:paragraph.toCharArray()){
            if(Character.isAlphabetic(c)){
                sb.append(c);
            }
            else{
                String s=sb.toString();
                if(!set.contains(s) && s.length()!=0){
                    map.put(s,map.getOrDefault(s,0)+1);
                }
                sb=new StringBuilder();
            }
        }
        String s=sb.toString();
        if(!set.contains(s)  && s.length()!=0){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int max=0;
        for(int i:map.values()){
            max=Math.max(max,i);
        }
       //  System.out.println(map+"===="+max);
        for(Map.Entry<String,Integer> e:map.entrySet()){
            if(e.getValue()==max){
                return e.getKey();
            }
        }
        return "";
    }
}