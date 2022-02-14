// { Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static HashMap<Integer,Boolean> map=new HashMap();
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        map.clear();
        return recurse(arr,sum,0);
    }
    static boolean recurse(int[] arr,int t,int l){
        if(map.containsKey(t)){
            return map.get(t);
        }
        if(t<0){
            return false;
        }
        if(t==0){
            return true;
        }
        for(int i=l;i<arr.length;i++){
            int r=t-arr[i];
            if(recurse(arr,(t-arr[i]),i+1)){
                map.put(t,true);
                return true;
            }
        }
        map.put(t,false);
        return false;
    }
}