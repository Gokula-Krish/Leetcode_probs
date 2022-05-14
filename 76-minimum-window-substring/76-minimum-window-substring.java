class Solution {
    public boolean check(int[] count,int[] count1){
        for(int i=0;i<58;i++){
            if(count[i]==0){
                continue;
            }
            else if(count1[i]>=count[i]){}
            else{
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int l=0,r=0,n=s.length();
        if(s.length()<t.length()){
            return "";
        }
        int[] count=new int[58];
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            count[c-'A']++;
        }
        int[] count1=new int[58];
        int start=-1,end=-1;
        int min=Integer.MAX_VALUE;
        while(l<=r && r<=n){
            if(check(count,count1)){
                int m=r-l;
                if(m<=min){
                    min=m;
                    start=l;end=r;
                }
                char c=s.charAt(l);
                if(count[c-'A']!=0){
                    count1[c-'A']--;
                }
                l++;
            }
            else{
                if(r<n){
                    char c=s.charAt(r);
                    if(count[c-'A']!=0){
                        count1[c-'A']++;
                    }
                }
                r++;
            }
        }
        if(start==-1 && end==-1){
            return "";
        }
        return s.substring(start,end);
    }
}