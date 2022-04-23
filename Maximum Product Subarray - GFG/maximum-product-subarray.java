// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long max=1,min=1,res=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            long c1=min*arr[i];
            long c2=max*arr[i];
            max=Math.max(arr[i],Math.max(c1,c2));
            min=Math.min(arr[i],Math.min(c1,c2));
            res=Math.max(res,Math.max(max,min));
        }
        return res;
    }
}