class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] arr1=arr.clone();
        Arrays.sort(arr1);
        HashMap<Integer,Integer> map=new HashMap();
       // System.out.println(Arrays.toString(arr1));
        int j=1;
        for(int i=0;i<arr1.length;i++){
            if(!map.containsKey(arr1[i])){
                map.put(arr1[i],j++);
            }
        }
        int[] ans=new int[arr.length];
        int k=0;
        for(int i:arr){
            ans[k++]=map.get(i);
        }
        return ans;
    }
}