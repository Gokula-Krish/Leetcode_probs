// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.searchInsertK(Arr, N, k));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int searchInsertK(int Arr[], int N, int k){
        // code here
        int l=0,r=N-1;
        while(l<r){
            int mid=(l+r)/2;
            if(k==Arr[mid]){
                return mid;
            }
            else if(k<Arr[mid]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return k>Arr[l]?++l:l;
    }
}