// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> map=new HashMap();
        int l=0,r=0,len=-1,n=s.length();
        char[] chS=s.toCharArray();
        while(l<=r && l<n && r<n){
            map.put(chS[r],map.getOrDefault(chS[r],0)+1);
            if(map.size()==k){
                len=Math.max(len,r-l+1);
            }
            else if(map.size()>k){
                while(map.size()>k){
                    map.put(chS[l],map.get(chS[l])-1);
                    if(map.get(chS[l])==0){
                        map.remove(chS[l]);
                    }
                    l++;
                }
            }
            r++;
        }
        return len;
    }
}