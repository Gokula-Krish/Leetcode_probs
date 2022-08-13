class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || numRows>s.length()){
            return s;
        }
        int n=s.length();
        int n1=n%2!=0?(n/2)+1:(n/2);
        char[][] arr=new char[numRows][n1];
        int l=0,r=0;
        int i=0;
        boolean zig=true,zag=false;
        while(i<n){
            if(zig && l>=numRows){
                l-=2;r++;
                zag=true;
                zig=false;
            }
            else if(zig && i<n){
                arr[l][r]=s.charAt(i++);
                l++;
            }
            else if(zag && l<0){
                zig=true;
                zag=false;
                l+=2;r--;
            }
            else if(zag && i<n){
                arr[l][r]=s.charAt(i++);
                l--;r++;
            }
        }
        String str="";
        for(i=0;i<numRows;i++){
            for(int j=0;j<n1;j++){
                if((int)arr[i][j]!=0){
                     str+=arr[i][j];
                }
            }
        }
        return str;
    }
}