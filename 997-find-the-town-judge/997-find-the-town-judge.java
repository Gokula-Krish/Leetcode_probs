class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        int[] t=new int[n+1];
      //  int max=0;
        for(int[] a:trust){
            t[a[1]]++;
         //   max=Math.max(max,t[a[1]]);
        }
        int j=0,a=0;
        for(int i:t){
            if(i!=0 && i==n-1){
                a=j;
            }
            j++;
        }
        for(int[] a1:trust){
            if(a1[0]==a){
                return -1;
            }
        }
        return a==0?-1:a;
    }
}