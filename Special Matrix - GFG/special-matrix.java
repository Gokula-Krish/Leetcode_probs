// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for(int i = 0; i < k; i++){
                String[] s1 = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int FindWays(int n, int m, int[][] blocked_cells){
        // Code here
        HashSet<Integer> row=new HashSet();
        HashSet<Integer> col=new HashSet();
        boolean[][] visited=new boolean[n][m];
        for(int[] a:blocked_cells){
            visited[a[0]-1][a[1]-1]=true;
        }
        int[][] dp=new int[n][m];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return dfs(0,0,n,m,visited,row,col,dp);
    }
    public int dfs(int r,int c,int n,int m,boolean[][] visited,HashSet<Integer> row,HashSet<Integer> col,int[][] dp){
        if(r>=n || c>=m || visited[r][c]){
            return 0;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        if(r==n-1 && c==m-1){
            return 1;
        }
        visited[r][c]=true;
        int right=dfs(r,c+1,n,m,visited,row,col,dp)%1000000007;
        int down=dfs(r+1,c,n,m,visited,row,col,dp)%1000000007;
        visited[r][c]=false;
        return dp[r][c]=(right+down)%1000000007;
    }
}