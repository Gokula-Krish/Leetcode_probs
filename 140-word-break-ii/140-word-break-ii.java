class Solution {
    ArrayList<String> ls=new ArrayList();
    int n;
    public void backTrack(String s,String t,int j){
        if(j>=n){
            ls.add(t.trim());
            return;
        }
        String str="";
        for(int i=j;i<n;i++){
            str+=s.charAt(i);
            if(set.contains(str)){
                backTrack(s,t+str+" ",i+1);
            }
        }
    }
    HashSet<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        n=s.length();
        set=new HashSet();
        for(String str:wordDict){
            set.add(str);
        }
        System.out.println(ls.size());
        backTrack(s,"",0);
        return ls;
    }
}