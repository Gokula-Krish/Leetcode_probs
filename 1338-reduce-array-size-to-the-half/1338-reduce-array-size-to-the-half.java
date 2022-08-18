class Solution {
    class Pair{
        int elem;
        int freq;
        Pair(int elem,int freq){
            this.elem=elem;
            this.freq=freq;
        }
    }
    public int minSetSize(int[] arr) {
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>(new Comparator<Pair>(){
           @Override
            public int compare(Pair p1,Pair p2){
               // return Integer.compare(p1.freq,p2.freq);
                if(p1.freq<p2.freq){
                    return 1;
                }
                else if(p1.freq>p2.freq){
                    return -1;
                }
                return 0;
            }
        });
        int size=arr.length;
        for(Map.Entry m:map.entrySet()){
            pq.add(new Pair((int)m.getKey(),(int)m.getValue()));
        }
        int n=arr.length;
        int c=0;
        while(true){
            Pair p=pq.poll();
            size-=p.freq;
            c++;
            if(size<=(n/2)){
                return c;
            }
        }
        
    }
}