class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific=new boolean[heights.length][heights[0].length];
        boolean[][] atlantic=new boolean[heights.length][heights[0].length];
        int m=heights.length,n=heights[0].length;
        for(int i=0;i<n;i++){
            bfs(heights,pacific,0,i);
            bfs(heights,atlantic,m-1,i);
        }
        for(int i=0;i<m;i++){
            bfs(heights,pacific,i,0);
            bfs(heights,atlantic,i,n-1);
        }
        List<List<Integer>> ls=new ArrayList();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> l=new ArrayList();
                    l.add(i);l.add(j);
                    ls.add(l);
                } 
            }
        }
        return ls;
    }
    int[] row={0,0,1,-1};
    int[] col={1,-1,0,0};
    public void bfs(int[][] A,boolean[][] visited,int r,int c){
        Queue<int[]> q=new LinkedList();
     //   boolean[][] visited=new boolean[A.length][A[0].length];
        q.add(new int[]{r,c});
        visited[r][c]=true;
        while(!q.isEmpty()){
            int[] p=q.poll();
            for(int i=0;i<4;i++){
                int pX=row[i]+p[0];
                int pY=col[i]+p[1];
                if(isValid(A,visited,pX,pY,p)){
                    q.add(new int[]{pX,pY});
                    visited[pX][pY]=true;
                }
            }
        }
    }
    public boolean isValid(int[][] A,boolean[][] visited,int r,int c,int[] p){
        return r>=0 && c>=0 && r<A.length && c<A[0].length && !visited[r][c] && A[p[0]][p[1]]<=A[r][c];
     }
}