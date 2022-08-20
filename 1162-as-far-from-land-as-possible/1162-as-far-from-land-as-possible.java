class Solution {
    public boolean isValid(int r,int c,int[][] mat){
        return r>=0 && c>=0 && r<mat.length && c<mat[0].length;
    }
    public int maxDistance(int[][] mat) {
        int n=mat.length;
        Queue<int[]> q=new LinkedList();
        int[] r={1,0,-1,0};
        int[] c={0,1,0,-1};
        boolean[][] visited=new boolean[n][n];
        int one=0,zero=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){one++;q.add(new int[]{i,j,0});}
                else{zero++;}
            }
        }
        if(zero==(n*n) || one==(n*n)){
            return -1;
        }
        while(!q.isEmpty()){
            int[] pair=q.poll();
            for(int i=0;i<4;i++){
                int pX=pair[0]+r[i];
                int pY=pair[1]+c[i];
                if(isValid(pX,pY,mat) && (mat[pX][pY]==0)){
                    if(visited[pX][pY]){
                        mat[pX][pY]=Math.min(mat[pX][pY],pair[2]+1);
                    }
                    else{
                        mat[pX][pY]=pair[2]+1;
                        visited[pX][pY]=true;
                        q.add(new int[]{pX,pY,pair[2]+1});
                    }
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,mat[i][j]);
            }
        }
        return max;
    }
}