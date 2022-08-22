class Solution {
    public List<String> commonChars(String[] words) {
        int[] count=new int[26];
        for(char c:words[0].toCharArray()){
            count[c-'a']++;
        }
        for(int i=1;i<words.length;i++){
            int[] count1=new int[26];
            for(char c:words[i].toCharArray()){
                count1[c-'a']++;
            }
           // System.out.println(Arrays.toString(count)+"-----"+Arrays.toString(count1));
            for(int j=0;j<26;j++){
                count1[j]=Math.min(count1[j],count[j]);
            }
            count=count1;
          //  System.out.println("FINAL "+Arrays.toString(count));
        }
        ArrayList<String> ls=new ArrayList();
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                for(int j=0;j<count[i];j++){
                    ls.add(((char)(i+'a'))+"");
                }
            }
        }
        return ls;
    }
}