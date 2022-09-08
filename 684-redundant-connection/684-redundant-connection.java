class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DS obj=new DS(1001);
        for(int[] arr:edges){
            if(obj.union(arr[0],arr[1])){
                return arr;
            }
        }
        return new int[]{-1,-1};
    }
}
class DS{
        int[] parent;int[] rank;
        DS(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int find(int node){
            if(node==parent[node]){
                return node;
            }
            return parent[node]=find(parent[node]);
        }
        public boolean union(int u,int v){
            u=find(u);v=find(v);
            if(u==v){
                return true;
            }
            else if(rank[u]<rank[v]){
                parent[u]=v;
            }
            else if(rank[v]<rank[u]){
                parent[v]=u;
            }
            else{
                parent[v]=u;rank[u]++;
            }
            return false;
        }
}