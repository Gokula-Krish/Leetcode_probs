class Solution {
    public int uniquePathsIII(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return recurse(grid,new boolean[grid.length][grid[0].length],i,j);
                }
            }
        }
        return 0;
    }
    public boolean check(boolean[][] visited,int[][] grid){
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[i].length;j++){
                if(grid[i][j]!=-1 && grid[i][j]!=2){
                    if(!visited[i][j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public int recurse(int[][] A,boolean[][] visited,int r,int c){
        if(r<0 || c<0 || r>=A.length || c>=A[0].length || A[r][c]==-1 || visited[r][c]){
            return 0;
        }
        if(A[r][c]==2){
            if(check(visited,A)){
                return 1;
            }
            return 0;
        }
        visited[r][c]=true;
        int top=recurse(A,visited,r-1,c);
        int bottom=recurse(A,visited,r+1,c);
        int left=recurse(A,visited,r,c-1);
        int right=recurse(A,visited,r,c+1);
        visited[r][c]=false;
        return top+bottom+left+right;
    }
}