class Solution {
    public boolean match(int[] count,String s){
        int[] count1=new int[26];
        for(char c:s.toCharArray()){
            count1[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(count[i]<=count1[i]){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> ans=new ArrayList();
        int[] map=new int[26];
        for(String s:words2){
            int[] count=new int[26];
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }
            for(int i=0;i<26;i++){
                map[i]=Math.max(map[i],count[i]);
            }
        }
        for(String s:words1){
            if(match(map,s)){
                ans.add(s);
            }
        }
        return ans;
    }
}