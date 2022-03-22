class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        Arrays.fill(ans,-1);
        Stack<Integer> st=new Stack();
        LinkedHashMap<Integer,Integer> lh=new LinkedHashMap();
        for(int i:nums2){
            while(!st.empty() && st.peek()<i){
                lh.put(st.peek(),i);
                st.pop();
            }st.push(i);
        }
        int k=0;
        for(int i:nums1){
            if(lh.containsKey(i)){
                ans[k]=(int)lh.get(i);
                lh.remove(i);
            }k++;
        }
        return ans;
    }
}