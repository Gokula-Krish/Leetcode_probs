class Solution {
     boolean isPalin(String str){
        int l=0,r=str.length()-1;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)){
                return false;
            }
            l++;r--;
        }
        return true;
    }
    List<String> ls=new ArrayList();
    List<List<String>> ans=new ArrayList();
    public void backtrack(String str,int j){
        if(j>=str.length()){
            ans.add(new ArrayList(ls));
            return;
        }
        for(int i=j;i<str.length();i++){
            if(isPalin(str.substring(j,i+1))){
                ls.add(str.substring(j,i+1));
                backtrack(str,i+1);
                ls.remove(ls.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        backtrack(s,0);
        return ans;
    }
}