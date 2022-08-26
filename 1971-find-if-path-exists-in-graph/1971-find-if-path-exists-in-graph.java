class Solution {
    boolean visit=false;
    public void dfs(LinkedList<Integer> list[],int j,int des,boolean[] visited){
        visited[j]=true;
        if(des==j){
            visit=true;
        }
        for(int i:list[j]){ 
            if(!visited[i]){
                dfs(list,i,des,visited);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        LinkedList<Integer> list[]=new LinkedList[n];
        for(int i=0;i<n;i++){
            list[i]=new LinkedList<Integer>();
        }
        for(int[] a:edges){
            list[a[0]].add(a[1]);
            list[a[1]].add(a[0]);
        }
        boolean[] visited=new boolean[n];
        dfs(list,source,destination,visited);
        return visit;
    }
}