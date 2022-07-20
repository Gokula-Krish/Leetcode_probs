class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        LinkedHashMap<String,Integer> map=new LinkedHashMap();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String,Integer> e:map.entrySet()){
            String str=e.getKey();
            int k=0,j=0;
            for(int i=0;i<s.length() && j<str.length();i++){
                if(s.charAt(i)==str.charAt(j)){
                    j++;k++;
                }
            }
            if(k==str.length()){
                count+=map.get(str);
            }
        }
        return count;
    }
}