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
        for(int i=0;i<=(s.length()-n);i++){
          //  System.out.println(s.substring(i,i+n));
            if(isValid(s.substring(i,i+n),map)){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean isValid(String str,HashMap<String,Integer> map){
        HashMap<String,Integer> map1=new HashMap();
       // System.out.println(str.length()-sub);
        for(int i=0;i<=(str.length()-sub);i+=sub){
            String s=str.substring(i,i+sub);
           // System.out.println(s);
            map1.put(s,map1.getOrDefault(s,0)+1);
        }      
      //  System.out.println(str+"-----"+map+"------"+map1);
        return map1.equals(map);
    }
}