class Solution {
    public boolean check(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character> map=new HashMap<Character,Character>();
        HashMap<Character,Character> map1=new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            if((map1.containsKey(t.charAt(i)) && map1.get(t.charAt(i))!=s.charAt(i))
              || (map.containsKey(s.charAt(i)) && map.get(s.charAt(i))!=t.charAt(i))){
                return false;
            }
            else{
                map.put(s.charAt(i),t.charAt(i));
                map1.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> ans=new ArrayList();
        for(String s:words){
            if(check(s,pattern)){
                ans.add(s);
            }       
        }
        return ans;
    }
}