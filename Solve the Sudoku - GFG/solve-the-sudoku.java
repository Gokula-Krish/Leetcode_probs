// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to find a solved Sudoku. 
    static public boolean solveSudoku(int[][] A,int r,int c){
        if(r==A.length-1 && c==A.length){
            return true;
        }
        if(c==A.length){
            r++;c=0;
        }
        if(A[r][c]!=0){
            return solveSudoku(A,r,c+1);
        }
        for(int i=1;i<=9;i++){
            if(isValid(A,r,c,i)){
                A[r][c]=i;
                if(solveSudoku(A,r,c+1)){
                    return true;
                }
                A[r][c]=0;
            }
        }
        return false;
    }
    static boolean isValid(int[][] A,int r,int c,int i){
        for(int j=0;j<9;j++){
            if(A[r][j]==i){
                return false;
            }
        }
        for(int j=0;j<9;j++){
            if(A[j][c]==i){
                return false;
            }
        }
        int s=r-(r%3),e=c-(c%3);
        for(int i1=0;i1<3;i1++){
            for(int j=0;j<3;j++){
                if(A[s+i1][e+j]==i){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean SolveSudoku(int grid[][]){
        // add your code here
        return solveSudoku(grid,0,0);
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][]){
        // add your code here
        for(int[] a:grid){
            for(int x:a){
                System.out.print(x+" ");
            }
        }
    }
}