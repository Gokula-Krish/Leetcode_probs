// { Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S1 = read.readLine();
            String S2 = read.readLine();

            Solution ob = new Solution();

            System.out.println(ob.findTime(S1,S2));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTime(String S1 , String S2) {
        // code here
        int[] map=new int[26];
        int i=0;
        for(char c:S1.toCharArray()){
            map[c-'a']=i++;
        }
        int sum=0;i=0;
        for(char c:S2.toCharArray()){
            sum+=Math.abs(map[c-'a']-i);
            i=map[c-'a'];
        }
        return sum;
    }
};