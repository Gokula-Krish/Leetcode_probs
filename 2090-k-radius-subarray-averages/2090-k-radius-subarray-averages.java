class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        int[] arr=new int[n];
        Arrays.fill(arr,-1);
        if(n<=k){
            return arr;
        }
        int d=k*2+1;
        if(n<d){
            return arr;
        }
        long sum=0;
        for(int i=0;i<d;i++){
            sum+=(long)nums[i];
        }
        int l=0,i;
        for(i=k;i<n-k-1;i++){
            arr[i]=(int)(sum/(long)d);
            sum-=(long)nums[l++];
            sum+=(long)nums[i+k+1];
        }
        arr[i]=(int)(sum/(long)d);
        return arr;
    }
}