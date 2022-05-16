// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}// } Driver Code Ends
// User function Template for Java
class Solution {
    public boolean isValid(int[][] A,boolean[][] visited,int r,int c,int N,int M){
        return (r>=0 && c>=0 && r<N && c<M && !visited[r][c] && A[r][c]==1);
    }
    int[] row={1,0,-1,0};
    int[] col={0,1,0,-1};
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if(A[X][Y]==0 || A[0][0]==0){
            return -1;
        }
        Queue<int[]> q=new LinkedList();
        q.add(new int[]{0,0,0});
        boolean[][] visited=new boolean[N][M];
        visited[0][0]=true;
        while(!q.isEmpty()){
            int[] pair=q.poll();
            if(pair[0]==X && pair[1]==Y){
                return pair[2];
            }
            for(int i=0;i<4;i++){
                int pX=pair[0]+row[i];
                int pY=pair[1]+col[i];
                if(isValid(A,visited,pX,pY,N,M)){
                    q.add(new int[]{pX,pY,pair[2]+1});
                    visited[pX][pY]=true;
                }
            }
        }
        return -1;
    }
};