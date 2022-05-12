class Solution {
    List<List<Integer>> ls=new ArrayList<List<Integer>>();
    Set<List<Integer>> set=new HashSet();
    public void perum(int[] arr,int i){
        if(i==arr.length-1){
            ArrayList<Integer> l1=new ArrayList<Integer>();
            for(int k=0;k<arr.length;k++){
                l1.add(arr[k]);
            }
            if(!(set.contains(l1))){
                ls.add(l1);
                set.add(new ArrayList(l1));
            }
            return;
        }
        else{
            for(int j=i;j<arr.length;j++){
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                perum(arr,i+1);
                t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        perum(nums,0);
        return ls;
    }
}