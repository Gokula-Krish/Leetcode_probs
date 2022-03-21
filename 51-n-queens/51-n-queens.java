class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n==1){
            ArrayList<String> a=new ArrayList<String>();
            a.add("Q");
            res.add(a);
            return res;
        }
        if(n==2){
            return res;
        }
        if(n==3){
            return res;
        }
        char mat[][]=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(mat[i],'.');
        }
        pass(0,mat,n);
        return res;
        
    }
    void pass(int ind ,char mat[][],int n){
        if(ind==n){
            ArrayList<String> al=new ArrayList<String>();
            for(int i=0;i<n;i++){
                String s="";
                for(int j=0;j<n;j++){
                    s+=mat[i][j];
                }
                al.add(s);
            }
            res.add(al);
            return;
        }
        for(int i=0;i<n;i++){
            if(mat[ind][i]=='.' && isValid(mat,ind,i,n)){
                mat[ind][i]='Q';
                pass(ind+1,mat,n);
                mat[ind][i]='.';
            }
        }
    }
    boolean isValid(char mat[][],int r,int c,int n){
        for(int i=0;i<n;i++){
            if(mat[r][i]!='.' || mat[i][c]!='.'){
                return false;
            }
            if(isValidPoints(r-i,c-i,n) && mat[r-i][c-i]!='.'){
                return false;
            }
            if(isValidPoints(r-i,c+i,n) && mat[r-i][c+i]!='.'){
                return false;
            }
            if(isValidPoints(r+i,c-i,n) && mat[r+i][c-i]!='.'){
                return false;
            }
            if(isValidPoints(r+i,c+i,n) && mat[r+i][c+i]!='.'){
                return false;
            }
        }
        return true;
    }
    boolean isValidPoints(int i,int j,int n){
        if(i<0 || i>=n || j<0 || j>=n){
            return false;
        }
        return true;
    }
}