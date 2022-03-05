// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            String s;
            s = br.readLine();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWithSpacesIntact(s));    
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    String reverseWithSpacesIntact(String S){
        // your code here
        char[] ch=S.toCharArray();
        int l=0,r=S.length()-1;
        while(l<r){
            while(ch[l]==' ' && l!=r){
                l++;
            }
            while(ch[r]==' ' && l!=r){
                r--;
            }
            char c=ch[l];
            ch[l]=ch[r];
            ch[r]=c;
            l++;r--;
        }
        return new String(ch);
    }
}