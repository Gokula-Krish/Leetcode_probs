class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        if(n<=1){
            return 0;
        }
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
           @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        boolean[][] visited=new boolean[n][n];
        pq.add(new int[]{grid[0][0],0,0});
        visited[0][0]=true;
        int[] row={1,-1,0,0};
        int[] col={0,0,1,-1};
        while(!pq.isEmpty()){
            int[] pairs=pq.poll();
            for(int i=0;i<4;i++){
                int pX=pairs[1]+row[i];
                int pY=pairs[2]+col[i];
                if(pX==n-1 && pY==n-1){
                    return Math.max(pairs[0],grid[pX][pY]);
                }
                if(pX>=0 && pY>=0 && pX<n && pY<n && !visited[pX][pY]){
                    visited[pX][pY]=true;
                    pq.add(new int[]{Math.max(grid[pX][pY],pairs[0]),pX,pY});
                }
            }
        }
        return -1;
    }
}