class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<1){
            return false;
        }
        double an=n;
        while(an>1){
            an/=3;
        }
        return an==1;
    }
}