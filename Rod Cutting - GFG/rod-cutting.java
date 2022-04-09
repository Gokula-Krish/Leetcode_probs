// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends
class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp=new int[n+1][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int[] len=new int[n];
        for(int i=1;i<=n;i++){
            len[i-1]=i;
        }
        int max=n;
        return rodCut(price,len,n,max,dp); 
    }
    public int rodCut(int[] price,int[] len,int n,int L,int[][] dp){
        if(n==0 || L==0){
            return 0;
        }
        int res;
        if(dp[n][L]!=-1){
            return dp[n][L];
        }
        if(len[n-1]>L){
            dp[n][L]=rodCut(price,len,n-1,L,dp);
        }
        else{
            dp[n][L]=Math.max(rodCut(price,len,n-1,L,dp),price[n-1]+rodCut(price,len,n,L-len[n-1],dp));
        }
        return dp[n][L];
    }
}