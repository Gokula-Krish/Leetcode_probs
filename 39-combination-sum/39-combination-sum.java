class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList();       
        getCombo(ans,candidates,target,new ArrayList(),0);
        return ans;
    }
    public void getCombo( List<List<Integer>> ans,int[] arr,int target,ArrayList<Integer> data,int i){
        if(target==0){
            ans.add(new ArrayList<>(data));
            return;
        }
        for(int j=i;j<arr.length;j++){
            if(target-arr[j]>=0){
                data.add(arr[j]);
                getCombo(ans,arr,target-arr[j],data,j);
                data.remove(data.size()-1);
            }
        }
    }
}