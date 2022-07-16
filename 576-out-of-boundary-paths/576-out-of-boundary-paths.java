class Solution {
    int[][][] grid;
    int M=1000000007;
    public int dfs(int n,int m,int i,int j,int moves,int max){
        if(moves>max){
            return 0;
        }
        if(i<0 || j<0 || i>=m || j>=n){
            return 1;
        }
        if(grid[i][j][moves]!=-1){
            return grid[i][j][moves];
        }
        grid[i][j][moves]=((dfs(n,m,i-1,j,moves+1,max)+dfs(n,m,i+1,j,moves+1,max))%M+(dfs(n,m,i,j-1,moves+1,max)+dfs(n,m,i,j+1,moves+1,max))%M)%M;
        return grid[i][j][moves];
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        grid=new int[m][n][maxMove+1];
        for(int[][] a:grid){
            for(int[] d:a){
                Arrays.fill(d,-1);
            }
        }
        return dfs(n,m,startRow,startColumn,0,maxMove);
    }
}