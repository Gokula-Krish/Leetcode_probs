class Solution {
    int count=0;
    public void countDFS(boolean[] visited,int[][] A,int j){
        visited[j]=true;
        for(int i=0;i<A[j].length;i++){
            if(!visited[i] && A[j][i]==1){
                countDFS(visited,A,i);
            }
        }
    }
    public int findCircleNum(int[][] A) {
        int n=A.length;
        boolean[] visited=new boolean[A.length];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i] && A[i][j]==1){
                    count++;
                    countDFS(visited,A,i);
                }
            }
        }
        return count;
    }
}