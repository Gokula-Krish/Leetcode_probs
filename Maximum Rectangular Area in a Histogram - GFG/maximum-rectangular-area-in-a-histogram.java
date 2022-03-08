// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends


class Solution{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) {
        // your code here
        Stack<Integer> stack=new Stack();
        int i=0,n1=(int)n;
        long max=-1;
        while(i<n1){
            if(stack.empty() || hist[stack.peek()]<=hist[i]){
                stack.push(i++);
            }
            else{
                int tp=stack.pop();
                long area=hist[tp]*(stack.empty()?i:i-stack.peek()-1);
                if(max<area){
                    max=area;
                }
            }
        }
        while(!stack.empty()){
            int tp=stack.pop();
                long area=hist[tp]*(stack.empty()?i:i-stack.peek()-1);
                if(max<area){
                    max=area;
                }
        }
        return max;
    }
        
}



