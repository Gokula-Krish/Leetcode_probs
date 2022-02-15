class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] count=new int[26];
        int[] count1=new int[26];
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            count[c-'a']++;
            count1[(s2.charAt(i))-'a']++;
        }
        int k=s1.length();
        for(int i=0;i<(s2.length()-k);i++){
            if(Arrays.equals(count,count1)){
                return true;
            }  
            char c=s2.charAt(i);
            char e=s2.charAt(i+k);
            count1[c-'a']--;
            count1[e-'a']++;
        }
        if(Arrays.equals(count,count1)){
            return true;
        }
        return false;
    }
}