class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int c=0;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return b[1]-a[1];
            }
        });
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            pq.add(new int[]{m.getKey(),m.getValue()});
        }
        int n=arr.length;
        int sum=0;
        while(!pq.isEmpty()){
            int c1=pq.poll()[1];
            sum+=c1;
            c++;
            if(sum>=(n/2)){
                return c;
            }
        }
        return c;
    }
}