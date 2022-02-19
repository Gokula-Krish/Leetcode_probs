// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(grid,visited,i,j);
                    n++;
                }
            }
        }
        return n;
    }
    public void dfs(char[][] A,boolean[][] visited,int r,int c){
        if(r<0 || c<0 || r>=A.length || c>=A[0].length || A[r][c]=='0' || visited[r][c]){
            return;
        }
        visited[r][c]=true;
        dfs(A,visited,r-1,c);
        dfs(A,visited,r+1,c);
        dfs(A,visited,r,c-1);
        dfs(A,visited,r,c+1);
        dfs(A,visited,r-1,c-1);
        dfs(A,visited,r-1,c+1);
        dfs(A,visited,r+1,c+1);
        dfs(A,visited,r+1,c-1);
    }
}