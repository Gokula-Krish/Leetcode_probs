class Solution {
    public boolean backTrack(char[][] board,int r,int c){
        if(r==board.length-1 && c==board.length){
            return true;
        }
        if(c==board.length){
            r++;c=0;
        }
        if(board[r][c]!='.'){
            return backTrack(board,r,c+1);
        }
        for(int i=1;i<=9;i++){
            if(isSafe(board,r,c,i)){
                board[r][c]=String.valueOf(i).charAt(0);
                if(backTrack(board,r,c+1)){
                    return true;
                }
                board[r][c]='.';
            }
        }
        return false;
    }
    public boolean isSafe(char[][] board,int r,int c,int n){
        char ch=String.valueOf(n).charAt(0);
        for(int i=0;i<9;i++){
            if(board[r][i]==ch){
                return false;
            }
        }
        for(int i=0;i<9;i++){        
            if(board[i][c]==ch){
                return false;
            }
        }
        int s=r-r%3,e=c-c%3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i+s][j+e]==ch){
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        backTrack(board,0,0);
    }
}