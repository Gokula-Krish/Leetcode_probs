class Solution {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        int k=0;
        for(int i=0;i<=n;i++){
            int c=0,j=i;
            while(j>0){
                c+=j & 1;
                j>>=1;
            }
            arr[k++]=c;
        }
        return arr;
    }
}