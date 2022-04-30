class Solution {
    public int maxNumberOfBalloons(String s) {
        int[] count=new int[26];
        int[] count1=new int[26];
        String s1="balloon";
        for(char c:s1.toCharArray()){
            count[c-'a']++;
        }
        for(char c1:s.toCharArray()){
            count1[c1-'a']++;
        }
        boolean pos=true;
        int c=0;
        while(pos){
            for(int i=0;i<count1.length;i++){
                if(count1[i]>=count[i]){
                    count1[i]-=count[i];
                }
                else{
                    pos=false;
                    break;
                }
            }
            if(pos){
                c++;
            }
            else{
                break;
            }
        }
        return c;
    }
}