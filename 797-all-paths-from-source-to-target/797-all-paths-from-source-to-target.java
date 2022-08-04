class Solution {
    List<List<Integer>> paths=new ArrayList();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        for(int i=0;i<graph[0].length;i++){
            ArrayList<Integer> ls=new ArrayList();
            ls.add(0);
            ls.add(graph[0][i]);
            dfs(graph,graph[0][i],ls,n);
        }
        return paths;
    }
    public void dfs(int[][] graph,int src,ArrayList<Integer> ls,int n){
        if(src==(n-1)){
            paths.add(new ArrayList(ls));
            return;
        }
        for(int i=0;i<graph[src].length;i++){
            ls.add(graph[src][i]);
            dfs(graph,graph[src][i],ls,n);
            ls.remove(ls.size()-1);
        }
    }
}