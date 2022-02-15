// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            Long[] res = ob.distributeCandies(N,K);
            
            for(int i=0; i<K; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long[] distributeCandies(int N, int K) {
        // code here
        int k=K,n=N;
        Long[] ans=new Long[k];
        for(int i=0;i<k;i++){
            ans[i]=(long)0;
        }
        int r=0,j=0;
        while(n>0){
            for(int i=0;i<k && n>0;i++){
                long an=k*r;
                if(n>=(an+(i+1))){
                    ans[i]+=an+(i+1);
                    n-=(an+i+1);
                }
                else{
                    ans[i]+=n;
                    n-=n;
                }
            }
            r++;
        }
        return ans;
    }
};