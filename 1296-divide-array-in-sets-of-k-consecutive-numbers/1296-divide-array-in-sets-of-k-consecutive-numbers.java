class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:nums){
            if(map.get(i)==0)continue;
            int c=0;
            while(map.getOrDefault(i,0)>0 && c<k){
                map.put(i,map.get(i)-1);
                c++;
                i++;
            }
            if(c<k){
                return false;
            }
        }
        return true;
    }
}