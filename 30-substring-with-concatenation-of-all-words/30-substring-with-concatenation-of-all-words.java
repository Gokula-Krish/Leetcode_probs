class Solution {
    int sub,n;
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> map=new HashMap();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        sub=words[0].length();
        n=sub*words.length;
        List<Integer> ans=new ArrayList();
        int n1=s.length();
        for(int i=0;i<=(n1-n);i++){
            if(isValid(s.substring(i,i+n),map)){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean isValid(String str,HashMap<String,Integer> map){
        HashMap<String,Integer> map1=new HashMap();
        for(int i=0;i<=(str.length()-sub);i+=sub){
            String s=str.substring(i,i+sub);
            map1.put(s,map1.getOrDefault(s,0)+1);
        }      
        return map1.equals(map);
    }
}