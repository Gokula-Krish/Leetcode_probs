// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.PriorityQueue; 

 // } Driver Code Ends
//User function Template for Java

class Solution { 
	public static int minOperations(int a[], int n) { 
	    // code here
	   int c=0;
	   PriorityQueue<Integer> pq=new PriorityQueue();
	   for(int i=0;i<n;i++){
	       if(!pq.isEmpty() && pq.peek()<a[i]){
	           c+=a[i]-pq.peek();
	           pq.poll();
	           pq.add(a[i]);
	       }
	       pq.add(a[i]);
	   }
	   return c;
	} 
} 


// { Driver Code Starts.
class GFG 
{ 
	
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);	
	    int t = sc.nextInt();
	    while (t > 0) {
	        int n;
	        n = sc.nextInt();
	        int[] a = new int[n];
	        for (int i = 0; i < n; i++) 
	        	a[i] = sc.nextInt();
	        Solution ob = new Solution();
	        System.out.println(ob.minOperations(a,n));
	        t--;
	    }
	}
}

  // } Driver Code Ends