// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isSafe(int[][] A,int r,int c,int e1){
        for(int i=0;i<9;i++){
            if(A[i][c]==e1 && i!=r){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(A[r][i]==e1 && i!=c){
                return false;
            }
        }
        int s=r-r%3,e=c-c%3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(A[s+i][e+j]==e1 && (s+i)!=r && (e+j)!=c){
                    return false;
                }
            }
        }
        return true;
    }
    static int isValid(int mat[][]){
        // code here
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]!=0){
                    if(isSafe(mat,i,j,mat[i][j])){}
                    else{
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
}