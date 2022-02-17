// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java
class Solution{
    void KswapPermutation(long arr[] ,int n,int k){
        TreeMap<Long,Integer> tm=new TreeMap(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            tm.put(arr[i],i);
        }
        int i=0;
        for(Map.Entry m:tm.entrySet()){
            if(i>=k){
                break;
            }
            if((long)m.getKey()==arr[i]){
                k++;
            }
            else{
                int j=(int)m.getValue();
                //long el=(long)m.getKey();
                long t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                tm.put(t,j);
            }i++;
        }

    }
}



// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            //int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[]=new long[n];
            for(int  i=0;i<n;i++)
            {
                arr[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            ob.KswapPermutation(arr,n,k);
            for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
}




  // } Driver Code Ends