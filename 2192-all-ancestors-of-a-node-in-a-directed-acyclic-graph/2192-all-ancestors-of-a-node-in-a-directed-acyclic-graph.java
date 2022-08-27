class Solution {
    TreeSet<Integer> set;
    boolean[] dfsVisit;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        LinkedList<Integer> list[]=new LinkedList[n];
        List<List<Integer>> ls=new ArrayList();
        for(int i=0;i<n;i++){
            list[i]=new LinkedList();
        }
        for(int[] arr:edges){
            list[arr[1]].add(arr[0]);
        }
        
        for(int i=0;i<n;i++){
            set=new TreeSet();
            dfsVisit=new boolean[n];
            dfs(list,i);
            ls.add(new ArrayList(set));
        }
        return ls;
    }
    public void dfs(LinkedList<Integer> list[],int j){
        dfsVisit[j]=true;
        for(int i:list[j]){
            if(!dfsVisit[i]){
                set.add(i);
                dfs(list,i);
            }
        }
    }
}