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
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    
     ArrayList<String> list=new ArrayList();
    public void addSpace(int i,String str){
        if(i==str.length()-1){
            list.add(0,new String(str));
            return;
        }
        addSpace(i+1,str);
        StringBuilder sb=new StringBuilder(str);
        sb.insert(i+1,' ');i++;
        str=new String(sb);
        addSpace(i+1,str);
        sb.deleteCharAt(i+1);
        str=new String(sb);
    }
    ArrayList<String> permutation(String S){
        // Code Here
        addSpace(0,S);
        return list;
    }
    
}