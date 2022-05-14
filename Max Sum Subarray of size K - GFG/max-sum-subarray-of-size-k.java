// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int sum=0,max=Integer.MIN_VALUE,l=0,r=0;
        while(l<=r && r<N){
            if((r-l+1)==K){
                sum+=Arr.get(r);
              //  System.out.println(sum+"--IF-R->"+r);
                max=Math.max(max,sum);
                sum-=Arr.get(l);
                l++;r++;
            }
            else{
                sum+=Arr.get(r);
                r++;
            }
        }
        return max;
    }
}