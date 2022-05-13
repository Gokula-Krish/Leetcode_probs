// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        HashSet<Character> set=new HashSet();
        int l=0,r=0,n=S.length()-1;
        int len=0;
        char[] chS=S.toCharArray();
        while(l<=r && l<=n && r<=n){
            if(l==r){
                set.add(chS[r]);
                len=Math.max(len,r-l+1);
             //   System.out.println(len+" if   ("+l+","+r+")");
                r++;
            }
            else if(set.contains(chS[r])){
                
               // System.out.println(chS[l]);
                set.remove(chS[l]);
               // System.out.println(len+"   ("+l+","+r+")");
                l++;
            }
            else{
                
                set.add(chS[r]);
                len=Math.max(len,r-l+1);
                r++;
            }
        }
        return len;
    }
}