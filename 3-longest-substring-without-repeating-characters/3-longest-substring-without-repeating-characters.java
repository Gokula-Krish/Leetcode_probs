class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap();
        int l=0,r=0,n=s.length(),len=0;
        char[] chS=s.toCharArray();
        while(r<n){
            if(map.containsKey(chS[r])){
                l=Math.max(map.get(chS[r])+1,l);
            }
            map.put(chS[r],r);
            len=Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
}