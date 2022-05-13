class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet();
        int l=0,r=0,n=s.length(),len=0;
        char[] chS=s.toCharArray();
        while(l<=r && l<n && r<n){
            if(set.contains(chS[r])){
                set.remove(chS[l]);
                l++;
            }
            else{
                set.add(chS[r]);
                len=Math.max(len,r-l+1);
                r++;
            }
        }
        return len;
    }
}