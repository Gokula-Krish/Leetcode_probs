// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public int findSubString(String s) {
        // Your code goes here
        int l=0,r=0;
        int min=s.length();
        HashMap<Character,Integer> map=new HashMap();
        int n=s.length();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int len=map.size();
      //  System.out.println(map+"-------"+map.size());
        map.clear();
        while(l<=r && r<=n){
            char c='0';
            
            if(map.size()==len){
              //  System.out.println("Got it..."+r+"--"+c);
              //  System.out.println("Map:"+map);
                while(map.size()==len){
                    c=s.charAt(l);
                    map.put(c,map.get(c)-1);
                    if(map.get(c)==0){
                        map.remove(c);
                    }
                  //  System.out.println(map);
                  //  System.out.println(s.substring(l,r));
                    min=Math.min(min,r-l);
                    l++;
                }
              //  System.out.println(min+"..."+l+"..."+r);
                
              //  System.out.println(map);
            }
            if(r<n){
                c=s.charAt(r);
            }
           // System.out.println("INto map: "+c);
            map.put(c,map.getOrDefault(c,0)+1);
            r++;
        }
    //    System.out.println("Final: "+map);
        return min;
    }
}