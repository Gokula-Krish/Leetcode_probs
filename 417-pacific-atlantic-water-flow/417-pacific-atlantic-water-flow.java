class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        List<List<Integer>> ans=new ArrayList(n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(bfs(heights,i,j)){
                    List<Integer> l=new ArrayList();
                    l.add(i);
                    l.add(j);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
    int[] row={-1,0,0,1};
    int[] col={0,1,-1,0};
    boolean pac=false;
    boolean atl=false;
    public boolean bfs(int[][] A,int r,int c){
        pac=false;
        atl=false;
        Queue<int[]> q=new LinkedList();
        boolean[][] visited=new boolean[A.length][A[0].length];
        q.add(new int[]{r,c});
        while(!q.isEmpty()){
            int[] pair=q.poll();
            for(int i=0;i<4;i++){
                int pX=pair[0]+row[i];
                int pY=pair[1]+col[i];
                if(isValid(pair,pX,pY,visited,A)){
                    q.add(new int[]{pX,pY});
                    visited[pX][pY]=true;
                }
            }
        }
        return pac && atl;
    }
    public boolean isValid(int[] pair,int r,int c,boolean[][] visited,int[][] A){
        if(c==A[0].length || r==A.length){
            pac=true;
        }
        if(c==-1 || r==-1){
            atl=true;
        }
        return (r>=0 && c>=0 && r<A.length && c<A[0].length && !visited[r][c] && A[pair[0]][pair[1]]>=A[r][c]);
    }
}