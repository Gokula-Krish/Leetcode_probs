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
            }
            else{
                max=Math.max(max,prices[r]-prices[l]);
            }
            r++;
        }
        return max;
    }
}