// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		
	    while(t-- >0)
	    {
	        String inputLine[] = br.readLine().trim().split(" ");
	        
	        //taking n and sum
            int n = Integer.parseInt(inputLine[0]);
            int sum = Integer.parseInt(inputLine[1]);
            
            //calling largestNumber() function
            System.out.println(new Solution().largestNumber(n, sum));
	    }
    }
}// } Driver Code Ends



class Solution{
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int n, int sum){
        // add your code here
        String str="";int c=0;
        StringBuilder sb=new StringBuilder();
        while(sum>=9 && c<n){
            sum-=9;
            sb.append(9);
            c++;
        }
        c=sb.length();
        while(sum!=0 && c<n){
            sb.append(sum);
            sum-=sum;
            c++;
        }
        for(int i=c;i<n;i++){
            sb.append(0);
        }
        return sum>0?String.valueOf(-1):new String(sb);
    }
}


