class Solution {
    LinkedList<Integer> graph[];
    boolean[] visited;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        graph=new LinkedList[n];
        for(int i=0;i<n;i++){
            graph[i]=new LinkedList();
        }
        for(int[] a:edges){
            graph[a[0]].add(a[1]);
            graph[a[1]].add(a[0]);
        }
        visited=new boolean[n];
        for(int i:restricted){
            visited[i]=true;
        }
        dfs(0);
        return c;
    }
    int c=1;
    public void dfs(int j){
        visited[j]=true;
        for(int vertex:graph[j]){
            if(!visited[vertex]){
                c++;
                dfs(vertex);
            }
        }
    }
}