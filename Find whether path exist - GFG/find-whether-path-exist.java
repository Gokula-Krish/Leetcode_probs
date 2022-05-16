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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends




class Solution{
    //Function to find whether a path exists from the source to destination.
    public boolean isValid(int[][] A,boolean[][] visited,int r,int c,int n){
        return (r>=0 && c>=0 && r<n && c<n && !visited[r][c] && (A[r][c]==3 || A[r][c]==2) && A[r][c]!=0 );
    }
    int[] row={-1,1,0,0};
    int[] col={0,0,-1,1};
    public boolean is_Possible(int[][] grid){
        // Code here
        int n=grid.length;
        Queue<int[]> q=new LinkedList();
        boolean[][] visited=new boolean[n][n];
        int x=-1,y=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    x=i;y=j;break;
                }
            }
        }
        if(x==-1 && y==-1){
            return false;
        }
        q.add(new int[]{x,y});
        visited[x][y]=true;
        while(!q.isEmpty()){
            int[] pair=q.poll();
            if(grid[pair[0]][pair[1]]==2){
                return true;
            }
            for(int i=0;i<4;i++){
                int pX=pair[0]+row[i];
                int pY=pair[1]+col[i];
                if(isValid(grid,visited,pX,pY,n)){
                    q.add(new int[]{pX,pY});
                    visited[pX][pY]=true;
                }
            }
        }
        return false;
    }
}