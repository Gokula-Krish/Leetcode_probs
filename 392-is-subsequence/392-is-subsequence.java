class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        int k=0,j=0;
        for(int i=0;i<t.length();i++){
            if(j<s.length() && t.charAt(i)==s.charAt(j)){
                j++;k++;
            }
        }
        if(k==s.length()){
            return true;
        }
        return false;
    }
}