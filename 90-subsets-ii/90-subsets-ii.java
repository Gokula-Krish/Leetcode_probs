class Solution {
    ArrayList<ArrayList<Integer>> an=new ArrayList();
    HashSet<ArrayList<Integer>> set=new HashSet();
    public void getAllSubSets(ArrayList<Integer> data,List<List<Integer>> ans,int i,int[] nums){
        if(i>=nums.length){
            if(!set.contains(data)){
                set.add(new ArrayList(data));
                ans.add(new ArrayList(data));
            }
            return;
        }
        data.add(nums[i]);
        getAllSubSets(data,ans,i+1,nums);
        data.remove(data.size()-1);
        getAllSubSets(data,ans,i+1,nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList();
        if(nums.length==0){
            return ans;
        }
        Arrays.sort(nums);
        ArrayList<Integer> l=new ArrayList();
        getAllSubSets(l,ans,0,nums);
        return ans;
    }
}