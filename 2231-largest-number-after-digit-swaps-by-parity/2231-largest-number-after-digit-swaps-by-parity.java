class Solution {
    public int largestInteger(int num) {
        String str=String.valueOf(num);
        PriorityQueue<Character> pq1=new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Character> pq2=new PriorityQueue(Collections.reverseOrder());
        for(char c:str.toCharArray()){
            if((c-'0')%2==0){
                pq2.add(c);
            }
            else{
                pq1.add(c);
            }
        }
        String ans="";
        for(char c:str.toCharArray()){
            if((c-'0')%2==0){
                ans+=pq2.poll();
            }
            else{
                ans+=pq1.poll();
            }
        }
        return Integer.parseInt(ans);
    }
}