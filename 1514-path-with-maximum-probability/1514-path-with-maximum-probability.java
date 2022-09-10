class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        LinkedList<double[]> G[]=new LinkedList[n];
        for(int i=0;i<n;i++){
            G[i]=new LinkedList<double[]>();
        }
        int i=0;
        for(int[] arr:edges){
            G[arr[0]].add(new double[]{arr[1],succProb[i]});
            G[arr[1]].add(new double[]{arr[0],succProb[i]});
            i++;
        }
        PriorityQueue<double[]> pq=new PriorityQueue<double[]>((a,b)->Double.compare(b[1],a[1]));
        pq.add(new double[]{start,1});
        double[] d=new double[n];
        Arrays.fill(d,0);
        d[start]=1;
        while(!pq.isEmpty()){
            double[] node=pq.poll();
            for(double[] arr:G[(int)node[0]]){
                if(d[(int)node[0]]*arr[1]>d[(int)arr[0]]){
                    d[(int)arr[0]]=d[(int)node[0]]*arr[1];
                    pq.add(new double[]{arr[0],d[(int)arr[0]]});
                }
            }
        }
        return d[end];
    }
}