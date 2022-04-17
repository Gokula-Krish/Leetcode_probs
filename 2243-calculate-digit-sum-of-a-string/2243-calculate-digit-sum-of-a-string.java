class Solution {
    public int getSum(String s){
        int sum=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            sum+=(c-'0');
        }
        return sum;
    }
    public String digitSum(String s, int k) {
        while(s.length()>k){
            ArrayList<String> ls=new ArrayList();
            String str="";
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                str+=c;
                if(i>0 && str.length()==k){
                    ls.add(str);
                    str="";
                }
            }
            if(!str.isEmpty()){
                ls.add(str);
            }
            String ans="";
            for(String st:ls){
                int sum=getSum(st);
                ans+=String.valueOf(sum);
            }
            s=ans;
        }
        return s;
    }
}