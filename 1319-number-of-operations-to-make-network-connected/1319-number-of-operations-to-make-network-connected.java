class Solution {
    public int makeConnected(int n, int[][] connections) {
        int wires=connections.length;
        if(wires<(n-1)){
            return -1;
        }
        LinkedList<Integer> list[]=new LinkedList[n];
        for(int i=0;i<n;i++){
            list[i]=new LinkedList<Integer>();
        }
        for(int[] a:connections){
            list[a[0]].add(a[1]);
            list[a[1]].add(a[0]);
        }
        boolean[] visited=new boolean[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(list,i,visited);
                c++;
            }
        }
        return c-1;
    }
    public void dfs(LinkedList<Integer> list[],int j,boolean[] visited){
        visited[j]=true;
        for(int i:list[j]){
            if(!visited[i]){
                dfs(list,i,visited);
            }
        }
    }
}