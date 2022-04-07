class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:stones){
            pq.add(x);
        }
        while(pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            if(x!=y){
                int z=Math.abs(y-x);
                pq.add(z);
            }
        }
        if(!pq.isEmpty()){
            return pq.poll();
        }
        return 0;
    }
}