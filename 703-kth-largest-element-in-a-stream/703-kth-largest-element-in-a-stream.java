class KthLargest {
    PriorityQueue<Integer> pq;
    int K;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<Integer>();
        for(int i:nums){
            pq.add(i);
        }
        K=k;
    }
    
    public int add(int val) {    
        pq.offer(val);
        while(pq.size()>K){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */