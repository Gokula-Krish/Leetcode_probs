class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int sum=0,j=0;
        for(int i=1;i<travel.length;i++){
            travel[i]+=travel[i-1];
        }
        HashMap<Character,Integer> map=new HashMap();
        int i=0;int count=0;
        for(String s:garbage){
            for(char c:s.toCharArray()){
                map.put(c,i);
                count++;
            }i++;
        }
        sum+=count;
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            int ans=e.getValue();
            if(ans!=0)sum+=travel[ans-1];
        }
        return sum;
    }
}