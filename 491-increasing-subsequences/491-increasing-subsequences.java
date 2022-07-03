class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans=new ArrayList();
        getSequence(nums,new ArrayList(),0,ans,Integer.MIN_VALUE);
        return ans;
    }
     public void getSequence(int[] arr,ArrayList<Integer> data,int l,List<List<Integer>> ans,int max){
        if(!data.isEmpty() && data.size()>1){
            ans.add(new ArrayList(data));
        }
        if(l>=arr.length){
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=l;i<arr.length;i++){
            if(set.contains(arr[i])){
                continue;
            }
            if(i>l && arr[i]==arr[i-1]){
                continue;
            }
            if(data.isEmpty()){
                max=Math.max(arr[i],max);
                data.add(arr[i]);
                set.add(arr[i]);
            }
            else if(data.get(data.size()-1)<=arr[i] && max<=arr[i]){
                max=Math.max(arr[i],max);
                data.add(arr[i]);
                set.add(arr[i]);
            }
            else if(data.get(data.size()-1)<=arr[i]){
                data.add(arr[i]);
                set.add(arr[i]);
            }
            else{
                continue;
            }
            getSequence(arr,data,i+1,ans,max);
            data.remove(data.size()-1);
        }
        return;
    }
}