class Solution {
    List<List<String>> ls=new ArrayList();
    public void solve(char[][] board,int[] row,int[] lowerDiag,int[] upperDiag,int c,int n){
        if(c==n){
            ArrayList<String> l=new ArrayList();
            for(char[] b:board){
                l.add(new String(b));
            }
            ls.add(l);
            return;
        }
        for(int r=0;r<n;r++){
            if(row[r]==0 && lowerDiag[r+c]==0 && upperDiag[n-1+c-r]==0){
                board[r][c]='Q';
                row[r]=1;
                lowerDiag[r+c]=1;
                upperDiag[n-1+c-r]=1;
                solve(board,row,lowerDiag,upperDiag,c+1,n);
                board[r][c]='.';
                row[r]=0;
                lowerDiag[r+c]=0;
                upperDiag[n-1+c-r]=0;
            }
            
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] d:board){
            Arrays.fill(d,'.');
        }
        int[] row=new int[n];
        int[] upperDiag=new int[2*n-1];
        int[] lowerDiag=new int[2*n-1];
        solve(board,row,lowerDiag,upperDiag,0,n);
        return ls;
    }
}