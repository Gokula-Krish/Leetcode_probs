class Solution {
    public int[] findAllDistance(int[] A,int n){
        int[] dist=new int[A.length];
        int d=0;
        int node=A[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[n]=0;
        boolean[] visited=new boolean[A.length];
        visited[n]=true;
        while(node!=-1 && !visited[node]){
            d++;
            dist[node]=d;
            visited[node]=true;
            node=A[node];
        }
        return dist;
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if(node1==node2){
            return node1;
        }
        int[] A=findAllDistance(edges,node1);
        int[] B=findAllDistance(edges,node2);
        int index=-1,min=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]!=Integer.MAX_VALUE && B[i]!=Integer.MIN_VALUE){
                if(min>Math.max(A[i],B[i])){
                    index=i;
                    min=Math.max(A[i],B[i]);
                }
            }
        }
        return index;
    }
}