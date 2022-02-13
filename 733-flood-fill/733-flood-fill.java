class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[i].length;j++){
                if(i==sr && j==sc){
                    dfs(image,i,j,newColor,new boolean[image.length][image[0].length],image[sr][sc]);
                    return image;
                }
            }
        }
        return image;
    }
    public void dfs(int[][] A,int r,int c,int newColor,boolean[][] visited,int e){
        if(r<0 || c<0 || r>=A.length || c>=A[0].length || visited[r][c] || A[r][c]!=e){
            return;
        }
        visited[r][c]=true;
        A[r][c]=newColor;
        dfs(A,r-1,c,newColor,visited,e);
        dfs(A,r+1,c,newColor,visited,e);
        dfs(A,r,c-1,newColor,visited,e);
        dfs(A,r,c+1,newColor,visited,e);
        return;
    }
}