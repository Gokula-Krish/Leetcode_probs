class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<1){
            return false;
        }
        double an=n;
        while(an>1){
            an/=4;
        }
        return an==1;
    }
}