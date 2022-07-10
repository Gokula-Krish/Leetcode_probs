// { Driver Code Starts
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
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid){
        // Code here
        Queue<int[]> q=new LinkedList();
        int d=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int[] r={0,0,-1,1};
        int[] c={-1,1,0,0};
        while(!q.isEmpty()){
            int n=q.size();
            boolean did=false;
            while(n-->0){
                int[] pair=q.poll();
                visited[pair[0]][pair[1]]=true;
                for(int i=0;i<4;i++){
                    int pX=pair[0]+r[i];
                    int pY=pair[1]+c[i];
                    if(isValid(grid,pX,pY,visited)){
                        did=true;
                        grid[pX][pY]=2;
                        q.add(new int[]{pX,pY});
                    }
                }
            }
            if(did){d++;}
        }
        return !allRotten(grid)?-1:d;
    }
    public boolean isValid(int[][] A,int r,int c,boolean[][] visited){
        return r>=0 && c>=0 && r<A.length && c<A[0].length && A[r][c]==1;
    }
    public boolean allRotten(int[][] A){
        for(int[] a:A){
            for(int x:a){
                if(x==1){
                    return false;
                }
            }
        }
        return true;
    }
}