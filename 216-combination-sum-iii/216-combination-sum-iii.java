class Solution {
    List<List<Integer>> ans=new ArrayList();
    public void findSubSets(int k,int sum,ArrayList<Integer> data,int j){
        if(sum==0 && k==data.size()){
            ans.add(new ArrayList<Integer>(data));
            return;
        }
        for(int i=j;i<=9;i++){
            data.add(i);
            findSubSets(k,sum-i,data,i+1);
            data.remove(data.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        findSubSets(k,n,new ArrayList(),1);
        return ans;
    }
}