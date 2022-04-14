class Solution {
    public int[][] generateMatrix(int n) {
        int c=1,n1=n-1;
        int[][] mat=new int[n][n];
        for(int i=0;i<(n+1)/2;i++){
            for(int j=i;j<n1;j++){
                mat[i][j]=c++;
            }
            for(int j=i;j<n1+1;j++){
                mat[j][n1]=c++;
            }
            c--;
            for(int j=n1;j>=i;j--){
                mat[n1][j]=c++;
            }
            c--;
            for(int j=n1;j>i;j--){
                mat[j][i]=c++;
            }
            n1--;
        }
        return mat;
    }
}