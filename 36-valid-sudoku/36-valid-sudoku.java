class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(Character.isDigit(board[i][j])){
                    if(isSafe(board,i,j,board[i][j])){}
                    else{
                       // System.out.println(i+"--"+j+" and "+board[i][j]);
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isSafe(char[][] board,int r,int c,char n){
        char ch=String.valueOf(n).charAt(0);
        for(int i=0;i<9;i++){
            if(board[r][i]==n && i!=c){
                return false;
            }
        }
        for(int i=0;i<9;i++){        
            if(board[i][c]==n && i!=r){
                return false;
            }
        }
        int s=r-r%3,e=c-c%3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i+s][j+e]==n && (i+s)!=r && (j+e)!=c){
                    return false;
                }
            }
        }
        return true;
    }
}