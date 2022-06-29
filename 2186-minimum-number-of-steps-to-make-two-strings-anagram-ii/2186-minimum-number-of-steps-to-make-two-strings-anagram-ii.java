class Solution {
    public int minSteps(String s, String t) {
        int[] count=new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        int[] count1=new int[26];
        for(char c:t.toCharArray()){
            count1[c-'a']++;
        }
        int s1=0,s2=0;
        for(int i=0;i<26;i++){
            s1+=Math.abs(count[i]-count1[i]);
        }
        return s1;
    }
}