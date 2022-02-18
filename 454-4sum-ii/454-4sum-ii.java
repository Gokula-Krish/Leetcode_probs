class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int c=0;
        HashMap<Integer,Integer> map=new HashMap();
        for(int i:nums3){
            for(int j:nums4){
                map.put(i+j,map.getOrDefault(i+j,0)+1);
            }
        }//USING COMBINED MAP FOR nums3 AND nums4 SO THAT THE COMPLEXITY CAN BE REDUCED TO O(N^2)
        for(int i:nums1){
            for(int j:nums2){
                int s=(i+j);
                c+=map.getOrDefault(-s,0);
            }
        }
        return c;
    }
}