class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!dfs(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int[][] A,int j,int[] color){
        if(color[j]==-1){color[j]=1;}
        for(int i:A[j]){
            if(color[i]==-1){
                color[i]=1-color[j];
                if(!dfs(A,i,color)){
                    return false;
                }
            }
            else if(color[i]==color[j]){
                return false;
            }
        }
        return true;
    }
}