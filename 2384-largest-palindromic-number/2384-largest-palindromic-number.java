class Solution {
    public boolean isPalindrome(String s){
        int l=0,r=s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;r--;
        }
        return  true;
    }
    public String largestPalindromic(String num) {
        if(num.charAt(0)!='0' && isPalindrome(num)){
            return num;
        }
        HashMap<Integer,Integer> map=new HashMap();
        for(char c:num.toCharArray()){
            map.put(c-'0',map.getOrDefault(c-'0',0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[]  b){
                return b[0]-a[0];
            }
        });
        PriorityQueue<Integer> pq1=new PriorityQueue(Collections.reverseOrder());
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int n=m.getValue();
            if(n>1 && n%2==0)
            {pq.add(new int[]{m.getKey(),m.getValue()});}
            else if(n>1 && n%2!=0){
                pq.add(new int[]{m.getKey(),n-1});
                pq1.add(m.getKey());
            }
            else
                pq1.add(m.getKey());
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            int a=pq.peek()[1]/2,b=pq.poll()[0];
            if(sb.length()==0){
                if(b==0){continue;}
            }
            for(int i=0;i<a;i++){
                sb.append(b);
            }
        }
        StringBuilder sb1=new StringBuilder(sb);
        sb.append(sb1.reverse());
        sb.append(!pq.isEmpty()?pq1.poll():"");
        sb.insert((sb.length())/2,pq1.poll());
        String s=sb.toString();
        return s.equals("null")?"0":s;
    }
}