class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character> lh=new HashMap<Character,Character>();
        HashMap<Character,Character> lh1=new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            if((lh1.containsKey(t.charAt(i)) && lh1.get(t.charAt(i))!=s.charAt(i))
              || (lh.containsKey(s.charAt(i)) && lh.get(s.charAt(i))!=t.charAt(i))){
                return false;
            }
            else{
                lh.put(s.charAt(i),t.charAt(i));
                lh1.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}