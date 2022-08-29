class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degrees=new int[n];
        for(int[] arr:roads){
            degrees[arr[1]]++;
            degrees[arr[0]]++;
        }
        HashSet<Integer> set[]=new HashSet[n];
        for(int i=0;i<n;i++){
            set[i]=new HashSet();
        }
        for(int[] arr:roads){
            set[arr[0]].add(arr[1]);
            set[arr[1]].add(arr[0]);
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                max=Math.max(max,degrees[j]+degrees[i]-(set[i].contains(j)?1:0));
            }
        }
        return max;
    }
}