class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || numRows>s.length()){
            return s;
        }
        int n=s.length();
        char[][] arr=new char[numRows][n%2!=0?(n/2)+1:(n/2)];
        int l=0,r=0;
        int i=0;
        boolean zig=true,zag=false;
        while(i<s.length()){
            if(zig && l>=numRows){
              //  System.out.println(l+"--ZIG---"+r);
                l-=2;r++;
            //    System.out.println("ZIG "+l+" and "+r);
                zag=true;
                zig=false;
            }
            else if(zig && i<n){
                //System.out.print(s.charAt(i));
                arr[l][r]=s.charAt(i++);
                l++;
            }
            else if(zag && l<0){
               // System.out.println(l+"--ZAG--"+r);
                zig=true;
                zag=false;
                l+=2;r--;
               // System.out.println("ZAG "+l+","+r);
            }
            else if(zag && i<n){
               // System.out.print(s.charAt(i));
                //System.out.println(l+" and "+r+" and i "+i);
                arr[l][r]=s.charAt(i++);
                l--;r++;
            }
            
        }
       // System.out.println(Arrays.deepToString(arr));
        // for(char[] ch:arr){
        //     System.out.println(Arrays.toString(ch));
        // }
        String str="";
        for(i=0;i<numRows;i++){
            for(int j=0;j<(n%2!=0?(n/2)+1:(n/2));j++){
                if((int)arr[i][j]!=0){
                     str+=arr[i][j];
                }
            }
        }
        return str;
    }
}