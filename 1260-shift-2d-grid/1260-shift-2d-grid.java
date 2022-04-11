class Solution {
    public void rotate(int[][] A,int r,int c){
        int prev=A[r-1][c-1];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int c1=A[i][j];
                A[i][j]=prev;
                prev=c1;
            }
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r=grid.length,c=grid[0].length;
        for(int i=0;i<k;i++){
            rotate(grid,r,c);
        }
        List<List<Integer>> ans=new ArrayList();
        for(int[] a:grid){
            List<Integer> l=new ArrayList();
            for(int e:a){
                l.add(e);
            }
            ans.add(l);
        }
        return ans;
    }
}