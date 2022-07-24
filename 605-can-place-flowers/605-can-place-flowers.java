class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int n1=flowerbed.length;
        for(int i=0;i<n1 && n>0;i++){
            if(flowerbed[i]==0 && n>0){
                boolean left=(((i-1)<0) || (flowerbed[i-1]==0))?true:false;
                boolean right=(((i+1)>=n1) || (flowerbed[i+1]==0))?true:false;
                if(left && right){
                    flowerbed[i]=1;
                    n--;
                }
            }
        }
        return n==0;
    }
}