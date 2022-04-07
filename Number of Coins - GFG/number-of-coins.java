// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    // } Driver Code Ends


class Solution{
	public int minCoins(int coins[], int M, int V) { 
	    // Your code goes here
	    int[][] dp=new int[M+1][V+1];
	    for(int i=0;i<dp.length;i++){
	        for(int j=0;j<dp[i].length;j++){
	            if(i==0){
	                dp[i][j]=99999;
	            }
	            else if(j==0){
	                dp[i][j]=0;
	            }
	            else if(j<coins[i-1]){
	                dp[i][j]=dp[i-1][j];
	            }
	            else{
	                dp[i][j]=Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
	            }
	        }
	    }
	    int ans=dp[M][V];
	    return ans==99999?-1:ans;
	} 
}