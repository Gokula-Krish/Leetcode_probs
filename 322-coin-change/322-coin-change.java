class Solution {
    // int min=Integer.MAX_VALUE;
    HashMap<Integer,Integer> map=new HashMap();
    public int findCoins(int[] coins,int s){
        if(s<0){
            return -1;
        }
        if(s==0){
            return 0;
        }
         if(map.containsKey(s)){
            return map.get(s);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int m=findCoins(coins,s-coins[i]);
            if(m>=0 && m<min){
                min=1+m;
            }
        }
        if(min==Integer.MAX_VALUE){
            map.put(s,-1);
        }
        else{
            map.put(s,min);
        }
        return map.get(s);
    }
    public int coinChange(int[] coins, int amount) {
        int ans=findCoins(coins,amount);
        return ans;
    }
}