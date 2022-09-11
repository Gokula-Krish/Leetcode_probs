class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=speed[i];
            arr[i][1]=efficiency[i];
        }
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        PriorityQueue<Integer> pq=new PriorityQueue();
        long max=0,speeds=0;
        for(int i=0;i<n;i++){
            if(pq.size()==k){
                speeds-=pq.poll();
            }
            pq.add(arr[i][0]);
            speeds+=arr[i][0];
            max=Math.max(max,arr[i][1]*speeds);
        }
        return (int)(max%1000000007);
    }
}