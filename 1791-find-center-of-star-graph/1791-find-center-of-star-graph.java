class Solution {
    public int findCenter(int[][] edges) {
        int n=0;
        for(int[] arr:edges){
            n=Math.max(n,arr[0]);
            n=Math.max(n,arr[1]);
        }
        int[] degrees=new int[n+1];
        for(int[] arr:edges){
            degrees[arr[0]]++;
            degrees[arr[1]]++;
        }
        int c=1;
        for(int i=1;i<=n;i++){
            if(degrees[i]==(n-1)){
                return i; 
            }
        }
        return -1;
    }
}