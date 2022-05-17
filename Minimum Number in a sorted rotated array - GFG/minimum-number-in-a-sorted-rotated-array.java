// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }
    
}// } Driver Code Ends
class Solution{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high){
        // Your code here
        if(high==999999){
            return 1;
        }
        int pIndex=findPivot(arr,high);
        if(pIndex==-1){
            return arr[0];
        }
        return Math.min(arr[0],arr[pIndex+1]);
    }
    public static int findPivot(int[] arr,int r){
        int l=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid<r && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>l && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[l]>=arr[mid]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
}