class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int l=0,r=1;
        int max=0;
        while(l<r && r<prices.length){
            if(prices[l]>prices[r]){
               // System.out.println(prices[l]+"---->"+prices[r]);
                l=r;
                r++;
            }
            else{
               // System.out.println(prices[l]+"--INSIDE-->"+prices[r]);
                max=Math.max(max,prices[r]-prices[l]);
                r++;
            }
        }
        return max;
    }
}