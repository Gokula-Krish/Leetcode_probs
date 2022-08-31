class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degrees=new int[n];
        for(int[] arr:roads){
            degrees[arr[0]]++;
            degrees[arr[1]]++;
        }
        Arrays.sort(degrees);
        long ans=0,v=n;
        for(int i=n-1;i>=0;i--){
            ans+=(degrees[i]*v--);
        }
        return (long)ans;
    }
}