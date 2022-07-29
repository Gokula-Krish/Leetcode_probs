class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        LinkedHashMap<Character,Character> lh=new LinkedHashMap<Character,Character>();
        LinkedHashMap<Character,Character> lh1=new LinkedHashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            if(lh.containsKey(s.charAt(i))){
                if(lh.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
            else{
                lh.put(s.charAt(i),t.charAt(i));
            }
        }
        for(int i=0;i<t.length();i++){
            if(lh1.containsKey(t.charAt(i))){
                if(lh1.get(t.charAt(i))!=s.charAt(i)){
                    return false;
                }
            }
            else{
                lh1.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}