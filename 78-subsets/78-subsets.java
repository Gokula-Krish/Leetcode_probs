class Solution {
    public void getSubSets(int[] nums,List<List<Integer>> ans,int i,ArrayList<Integer> data){
        if(i>=nums.length){
            ans.add(new ArrayList(data));
            return;
        }
        data.add(nums[i]);
        getSubSets(nums,ans,i+1,data);
        data.remove(data.size()-1);
        getSubSets(nums,ans,i+1,data);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList();
        ArrayList<Integer> data=new ArrayList();
        getSubSets(nums,ans,0,data);
        return ans;
    }
}