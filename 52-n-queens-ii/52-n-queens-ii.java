class Solution {
    int count=0;
    public void recursion(char[][] board,int col){
        if(col==board.length){
            count++;
            return;
        }
        for(int r=0;r<board.length;r++){
            if(isSafe(board,r,col)){
                board[r][col]='Q';
                recursion(board,col+1);
                board[r][col]='.';
            }
        }
    }
    public boolean isSafe(char[][] board,int r,int c){
        for(int i=0;i<c;i++){
            if(board[r][i]!='.'){
                return false;
            }
        }
        for(int i=r,j=c;i>=0 && j>=0;i--,j--){
            if(board[i][j]!='.'){
                return false;
            }
        }
        for(int i=r,j=c;i<board.length && j>=0;i++,j--){
            if(board[i][j]!='.'){
                return false;
            }
        }
        return true;
    }
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] ch:board){
            Arrays.fill(ch,'.');
        }
        recursion(board,0);
        return count;
    }
}