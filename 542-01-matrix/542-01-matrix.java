class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q=new LinkedList();
        int zero=0;
        int[] r={1,0,-1,0};
        int[] c={0,1,0,-1};
        boolean[][] visited=new boolean[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int n=q.size();
            int[] pair=q.poll();
            for(int i=0;i<4;i++){
                int pX=pair[0]+r[i];
                int pY=pair[1]+c[i];
                if(isValid(pX,pY,mat) && (mat[pX][pY]==1)){
                    if(visited[pX][pY]){
                        mat[pX][pY]=Math.min(mat[pX][pY],mat[pair[0]][pair[1]]+1);
                    }
                    else{
                        mat[pX][pY]=mat[pair[0]][pair[1]]+1;
                        visited[pX][pY]=true;
                        q.add(new int[]{pX,pY});
                    }
                }
            }
        }
        return mat;
    }
    public boolean isValid(int r,int c,int[][] mat){
        return r>=0 && c>=0 && r<mat.length && c<mat[0].length;
    }
}