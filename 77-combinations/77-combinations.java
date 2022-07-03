class Solution {
    public void recursion(int n,int k,List<Integer> data,List<List<Integer>> ans,int l){
        if(data.size()==k){
            ans.add(new ArrayList(data));
            return;
        }
        for(int i=l;i<=n;i++){
            data.add(i);
            recursion(n,k,data,ans,i+1);
            data.remove(data.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> ls=new ArrayList();
        int[] arr=new int[k];
        recursion(n,k,new ArrayList(),ans,1);
        return ans;
    }
}