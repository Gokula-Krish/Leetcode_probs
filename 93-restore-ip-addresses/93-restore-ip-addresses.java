class Solution {
    int c=0;
    ArrayList<String> ls=new ArrayList();
    public boolean isValid(String sb){
        if(sb.length()>1 && sb.charAt(0)=='0') return false;
        if(sb.length()>3)return false;
        int a=Integer.parseInt(sb.toString());
        if(a>255)return false;
        return true;
       
    }
    public void back(String sb,String str,int j,int dots){
        if(j>=n){
            return;
        }
        if(dots==3){
            String s1=str.substring(j,str.length());
            if(isValid(s1)){
                ls.add(sb+s1);
            }
            return;
        }
        String ssb="";
        for(int i=j;i<n;i++){
            ssb+=str.charAt(i);
            if(dots<3 && isValid(ssb)){
                back(sb+ssb+".",str,i+1,dots+1);
            }
        }
    }
    int n;
    public List<String> restoreIpAddresses(String s) {
        n=s.length();
        back("",s,0,0);
        return ls;
    }
}