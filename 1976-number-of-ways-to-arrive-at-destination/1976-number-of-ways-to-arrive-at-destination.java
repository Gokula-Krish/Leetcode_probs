class Solution {
    int mod=(int)1e9+7;
    public int countPaths(int n, int[][] roads) {
        LinkedList<int[]> G[]=new LinkedList[n];
        for(int i=0;i<n;i++){
            G[i]=new LinkedList<int[]>();
        }
        for(int[] arr:roads){
            G[arr[0]].add(new int[]{arr[1],arr[2]});
            G[arr[1]].add(new int[]{arr[0],arr[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
        int[] d=new int[n];
        int[] ways=new int[n];
        ways[0]=1;
        Arrays.fill(d,Integer.MAX_VALUE);
        d[0]=0;
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){ 
            int[] node=pq.poll();
            if(node[1] > d[node[0]]) 
                continue;
            for(int[] arr:G[node[0]]){
                if(d[node[0]]+arr[1]<d[arr[0]]){
                    d[arr[0]]=d[node[0]]+arr[1];
                    ways[arr[0]]=ways[node[0]];
                    pq.add(new int[]{arr[0],d[arr[0]]});
                }
                else if(d[node[0]]+arr[1]==d[arr[0]]){
                    ways[arr[0]]+=ways[node[0]];
                    ways[arr[0]]%=mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}