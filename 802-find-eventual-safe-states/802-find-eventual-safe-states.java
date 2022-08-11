class Solution {
    ArrayList<Integer> ls=new ArrayList();
   public boolean dfs(int[][] adj,int v,boolean[] visited,boolean[] reStack){
        if(reStack[v]){
           // System.out.println("CYCLE: "+v);
            return true;
        }
        if(visited[v]){
            return false;
        }
        visited[v]=true;
        reStack[v]=true;
        for(int i=0;i<adj[v].length;i++){
           // System.out.println("NODES in "+v+" are "+i);
            if(dfs(adj,adj[v][i],visited,reStack)){
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
            if(dfs(graph,i,visited,dfsVisit)){
                
            }
            else{
                ls.add(i);
            }
        }
        
        return ls;
    }
}