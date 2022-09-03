class Solution {
    public void dfs(LinkedList<Integer> list[],int src,boolean[] visited,HashSet<Integer> set[]){
        visited[src]=true;
        for(int i:list[src]){
            if(!visited[i]){
                if(set[src].contains(i)){
                    c++;
                }
                dfs(list,i,visited,set);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        LinkedList<Integer> list[]=new LinkedList[n];
        HashSet<Integer> set[]=new HashSet[n];
        for(int i=0;i<n;i++){
            list[i]=new LinkedList();
            set[i]=new HashSet();
        }
        for(int[] arr:connections){
            set[arr[0]].add(arr[1]);
            list[arr[0]].add(arr[1]);
            list[arr[1]].add(arr[0]);
        }
        dfs(list,0,new boolean[n],set);
        return c;
    }
    int c=0;
}