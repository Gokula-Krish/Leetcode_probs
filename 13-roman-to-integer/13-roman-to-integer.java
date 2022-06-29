class Solution {
    public int romanToInt(String s) {
        LinkedHashMap<Character,Integer> lh=new LinkedHashMap<Character,Integer>();
        lh.put('I',1);
        lh.put('V',5);
        lh.put('X',10);
        lh.put('L',50);
        lh.put('C',100);
        lh.put('D',500);
        lh.put('M',1000);
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(i+1<s.length() && s.charAt(i)=='I' && s.charAt(i+1)!='I' && i==0){
                ans-=1;
            }
            else if(i+1<s.length() && lh.get(s.charAt(i))<lh.get(s.charAt(i+1))){
                ans-=lh.get(s.charAt(i));
            }
            else if(i+1<s.length() && lh.get(s.charAt(i))>=lh.get(s.charAt(i+1))){
                ans+=lh.get(s.charAt(i));
            }
            else{
                ans+=lh.get(s.charAt(i));
            }
        }
        return ans;
    }
}