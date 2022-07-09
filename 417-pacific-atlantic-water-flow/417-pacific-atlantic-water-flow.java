class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        List<List<Integer>> ans=new ArrayList(n);
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];
        for(int i=0;i<n;i++){
            bfs(heights,0,i,pacific);
            bfs(heights,m-1,i,atlantic);
        }
        for(int i=0;i<m;i++){
            bfs(heights,i,0,pacific);
            bfs(heights,i,n-1,atlantic);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> l=new ArrayList();
                    l.add(i);
                    l.add(j);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
    int[] row={0,0,1,-1};
    int[] col={1,-1,0,0};
    public void bfs(int[][] A,int r,int c,boolean[][] ocean){
        Queue<int[]> q=new LinkedList();
        q.add(new int[]{r,c});
        ocean[r][c]=true;
        while(!q.isEmpty()){
            int[] pair=q.poll();
            for(int i=0;i<4;i++){
                int pX=pair[0]+row[i];
                int pY=pair[1]+col[i];
                if(isValid(pair,pX,pY,ocean,A)){
                    q.add(new int[]{pX,pY});
                    ocean[pX][pY]=true;
                }
            }
        }
    }
    public boolean isValid(int[] pair,int r,int c,boolean[][] visited,int[][] A){
        return (r>=0 && c>=0 && r<A.length && c<A[0].length && !visited[r][c] && A[pair[0]][pair[1]]<=A[r][c]);
    }
}