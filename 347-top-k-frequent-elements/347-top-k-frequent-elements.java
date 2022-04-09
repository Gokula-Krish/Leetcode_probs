class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>(){
           @Override
            public int compare(Integer a,Integer b){
                return map.get(b)-map.get(a);
            }
        });
        for(Map.Entry m:map.entrySet()){
            pq.add((int)m.getKey());
        }
        int[] ans=new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=pq.poll();
        }
        return ans;
    }
}