class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] vis=new boolean[n];
        int[] tim=new int[n];
        int[] low=new int[n];
        int timer=0;
        LinkedList<Integer> list[]=new LinkedList[n];
        for(int i=0;i<n;i++){
            list[i]=new LinkedList();
        }
        for(List<Integer> l:connections){
            list[l.get(0)].add(l.get(1));
            list[l.get(1)].add(l.get(0));
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,-1,vis,tim,low,list,timer);
            }
        }
        return ls;
    }
    List<List<Integer>> ls=new LinkedList();
    public void dfs(int i,int parent,boolean[] vis,int[] tim,int[] low,LinkedList<Integer> G[],int timer){
        vis[i]=true;
        tim[i]=low[i]=timer++;
        for(int j:G[i]){
            if(j==parent) continue;
            if(!vis[j]){
                dfs(j,i,vis,tim,low,G,timer);
                low[i]=Math.min(low[i],low[j]);
                if(low[j]>tim[i]){
                    List<Integer> l=new LinkedList();
                    l.add(i);l.add(j);
                    ls.add(l);
                }
            }
            else{
                low[i]=Math.min(low[i],tim[j]);
            }
        }
    }
}