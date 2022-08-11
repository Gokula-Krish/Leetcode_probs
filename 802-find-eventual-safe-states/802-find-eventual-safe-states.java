class Solution {
    ArrayList<Integer> ls=new ArrayList();
   public boolean dfs(int[][] adj,int v,boolean[] visited,boolean[] reStack){
        if(reStack[v]){
            return true;
        }
       if(visited[v]){
           return false;
       }
        visited[v]=true;
        reStack[v]=true;
        for(int i:adj[v]){
            if(dfs(adj,i,visited,reStack)){
                return true;
            }
        }
        reStack[v]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int i=0,n=graph.length;
        boolean[] visited=new boolean[n];
        boolean[] dfsVisit=new boolean[n];
       // Arrays.fill(safe,true);
        for(i=0;i<n;i++){
            if(!dfs(graph,i,visited,dfsVisit)){
                ls.add(i);
            }
        }        
        return ls;
    }
}