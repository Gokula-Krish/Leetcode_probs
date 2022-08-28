class Solution {
    public long countPairs(int n, int[][] edges) {
        LinkedList<Integer> list[]=new LinkedList[n];
        for(int i=0;i<n;i++){
            list[i]=new LinkedList();
        }
        for(int[] arr:edges){
            list[arr[0]].add(arr[1]);
            list[arr[1]].add(arr[0]);
        }
        long ans=0,nodes=n;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                c=0;
                dfs(list,i,visited);
                ans+=(nodes-c)*c;
                nodes-=c;
            }
        }
        return ans;
    }
    long c=0;
    public void dfs(LinkedList<Integer> list[],int src,boolean[] visited){
        visited[src]=true;
        c++;
        for(int i:list[src]){
            if(!visited[i]){
                dfs(list,i,visited);
            }
        }
    }
}