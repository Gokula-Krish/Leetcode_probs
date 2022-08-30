class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length,n1=n-1;
        int c=0;
        for(int i=0;i<(n/2);i++){
            int l=n1,r=n1;
           // System.out.println(l+","+r+","+n1);
            for(int j=c;j<n1;j++){
               int t= matrix[l][i];
                matrix[l][i]=matrix[n1][r];
                matrix[n1][r]=matrix[j][n1];
                matrix[j][n1]=matrix[i][j];
                matrix[i][j]=t;
                l--;r--;
            }n1--;c++;
        }
    }
}