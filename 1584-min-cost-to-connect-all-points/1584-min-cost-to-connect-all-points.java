class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        LinkedList<int[]> graph[]=new LinkedList[n];
        for(int i=0;i<n;i++){
            graph[i]=new LinkedList();
        }
        for(int i=0;i<n;i++){
            int[] a=points[i];
            for(int j=i+1;j<n;j++){
                int diff=Math.abs(a[0]-points[j][0])+Math.abs(a[1]-points[j][1]);
                graph[i].add(new int[]{j,diff});
                graph[j].add(new int[]{i,diff});
            }
        }
        int cost=0;
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
           @Override
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });
        HashSet<Integer> visit=new HashSet();
        pq.add(new int[]{0,0});
        while(visit.size()<n){
            int[] edg=pq.poll();
            if(visit.contains(edg[0])){
                continue;
            }
            visit.add(edg[0]);
            cost+=edg[1];
            for(int[] arr:graph[edg[0]]){
                if(!visit.contains(arr[0])){
                    pq.add(arr);
                }
            }
        }
        return cost;
    }
}