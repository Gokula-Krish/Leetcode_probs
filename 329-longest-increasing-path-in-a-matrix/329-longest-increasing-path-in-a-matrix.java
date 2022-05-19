class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        boolean[][] visited=new boolean[matrix.length][matrix[0].length];
        int ans=Integer.MIN_VALUE;
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                ans=Math.max(ans,recurse(matrix,dp,visited,i,j));
            }
        }
        return ans;
    }
    public int recurse(int[][] A,int[][] dp,boolean[][] visited,int r,int c){
        if(r<0 || c<0 || r>=A.length || c>=A[0].length || visited[r][c]){
            return 0;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int w=0,x=0,y=0,z=0;
        visited[r][c]=true;
        if((c-1)>=0 && A[r][c]<A[r][c-1]){
            w=1+recurse(A,dp,visited,r,c-1);
        }
        if((c+1)<A[0].length && A[r][c]<A[r][c+1]){
            x=1+recurse(A,dp,visited,r,c+1);
        }
        if((r-1)>=0 && A[r][c]<A[r-1][c]){
            y=1+recurse(A,dp,visited,r-1,c);
        }
        if((r+1)<A.length && A[r][c]<A[r+1][c]){
            z=1+recurse(A,dp,visited,r+1,c);
        }
        visited[r][c]=false;
        dp[r][c]=Math.max(x,Math.max(y,Math.max(z,Math.max(w,1))));;
        return dp[r][c];
    }
}