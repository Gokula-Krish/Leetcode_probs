class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        TreeMap<Integer,Integer> map=new TreeMap();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            map.put(sum,i);
        }
        int[] answer=new int[queries.length];
        int k=0;
        for(int i:queries){
            Integer key=map.floorKey(i);
            if(key!=null)
                answer[k]=map.get(key)+1;
            k++;
        }
        return answer;
    }
}