class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ls=new ArrayList();
        if(p.length()>s.length()){
            return ls;
        }
        int[] count=new int[26];
        for(char c:p.toCharArray()){
            count[c-'a']++;
        }
        int[] count1=new int[26];
        for(int i=0;i<p.length();i++){
            count1[s.charAt(i)-'a']++;
        }
        int d=p.length(),n=s.length();
        int i;
        for(i=0;i<n-d;i++){
            if(Arrays.equals(count,count1)){
                ls.add(i);
            }
            count1[s.charAt(i)-'a']--;
            count1[s.charAt(i+d)-'a']++;
        }
        if(Arrays.equals(count,count1)){
             ls.add(i);
        }
        return ls;
    }
}