class Solution {
    int[] dist;
    public int networkDelayTime(int[][] times, int n, int k) {
        bellmanFord(n,times,k);
        int max=-1;
        for(int i=1;i<=n;i++){
            if(dist[i]!=10000 && i!=k){
                max=Math.max(max,dist[i]);   
            }
            else if(dist[i]==10000){
                return -1;
            }
        }
        return max;
    }
    void bellmanFord(int V,int[][] A, int S){
         dist=new int[V+1];
         Arrays.fill(dist,10000);
         dist[S]=0;
         for(int i=1;i<=V;i++){
             for(int[] l:A){
                 int u=l[0],v=l[1],cost=l[2];
                 if(dist[u]+cost<dist[v]){
                     dist[v]=dist[u]+cost;
                 }
             }
         }
    }
}