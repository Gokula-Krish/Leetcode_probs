class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
        int current=startFuel,prev=0,c=0;
        for(int[] arr:stations){
            current-=arr[0]-prev;
            while(!pq.isEmpty() && current<0){
                current+=pq.poll();c++;
            }
            if(current<0){return -1;}
            pq.add(arr[1]);
            prev=arr[0];
        }
        current-=target-prev;
        while(!pq.isEmpty() && current<0){
            current+=pq.poll();c++;
        }if(current<0){return -1;}
        return c;
    }
}