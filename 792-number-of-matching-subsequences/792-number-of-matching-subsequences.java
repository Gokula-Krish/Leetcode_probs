class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        LinkedHashMap<String,Integer> map=new LinkedHashMap();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        char[] arr=s.toCharArray();
        for(Map.Entry<String,Integer> e:map.entrySet()){
            char[] arr1=(e.getKey()).toCharArray();
            int k=0,j=0;
            for(int i=0;i<arr.length && j<arr1.length;i++){
                if(arr[i]==arr1[j]){
                    j++;k++;
                }
            }
            if(k==arr1.length){
                count+=map.get(e.getKey());
            }
        }
        return count;
    }
}