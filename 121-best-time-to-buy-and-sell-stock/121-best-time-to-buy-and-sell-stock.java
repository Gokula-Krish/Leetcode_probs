class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<=1){
            return 0;
        }
        int l=0,r=1;
        int max=0;
        while(l<r && r<n){
            if(prices[l]>prices[r]){
                l=r;
                r+=1;
            }
            else{
                int diff=prices[r]-prices[l];
                max=Math.max(max,diff);
                r+=1;
            }
        }
        return max;
    }
}