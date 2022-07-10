class Solution {
    public int orangesRotting(int[][] grid) {
        int d=0;
        Queue<int[]> q=new LinkedList();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                     q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            boolean did=false;
            int n=q.size();
            while(n-->0){
                int[] pair=q.poll();
                for(int i=0;i<4;i++){
                    int pX=pair[0]+r[i];
                    int pY=pair[1]+c[i];
                    if(isValid(grid,pX,pY)){
                        did=true;
                        grid[pX][pY]=2;
                        q.add(new int[]{pX,pY});
                    }
                }
            }
            if(did){d++;}
        }
        return !allRotten(grid)?-1:d;
    }
    int[] r={0,0,1,-1};
    int[] c={1,-1,0,0};
    public boolean isValid(int[][] A,int r,int c){
        return r>=0 && c>=0 && r<A.length && c<A[0].length && (A[r][c]==1);
    }
    public boolean allRotten(int[][] A){
        for(int[] a:A){
            for(int x:a){
                if(x==1){
                    return false;
                }
            }
        }
        return true;
    }
}