class Solution {
    public int getIndex(ArrayList<Integer> ls,int t){
        int l=0,r=ls.size()-1,res=0;
        while(l<=r){
            int mid=(r+l)/2;
            if(ls.get(mid)==t){
                res=mid;
                r=mid-1;
            }
            else if(t>ls.get(mid)){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return res;
    }
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> list=new ArrayList();
        for(int i:nums){
            list.add(i);
        }
        Collections.sort(list);
        ArrayList<Integer> ans=new ArrayList();
        for(int i=0;i<nums.length;i++){
            int in=getIndex(list,nums[i]);
            ans.add(in);
            list.remove(in);
        }
        return ans;
    }
}