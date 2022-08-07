class Solution {
    int mod=(int)Math.pow(10,9)+7;
    int[][] dp;
    public int backtrack(int len,char last,int n){
        if(len==n){
            return 1;
        }
        long cnt=0;
        if(last=='z'){
            if(dp[5][len]!=-1){
                return dp[5][len]%mod;
            }
         cnt=(cnt+backtrack(len+1,'a',n)%mod+backtrack(len+1,'e',n)%mod
             +backtrack(len+1,'i',n)%mod+backtrack(len+1,'o',n)%mod+backtrack(len+1,'u',n)%mod)%mod;
            dp[5][len]=(int)cnt%mod;
        }
        else if(last=='a'){
             if(dp[0][len]!=-1){
                return dp[0][len]%mod;
            }
            cnt=(cnt+backtrack(len+1,last='e',n))%mod;
            dp[0][len]=(int)cnt%mod;
        }
        else if(last=='e'){
             if(dp[1][len]!=-1){
                return dp[1][len]%mod;
            }
            cnt=(cnt+backtrack(len+1,last='a',n)+backtrack(len+1,last='i',n))%mod;
            dp[1][len]=(int)cnt%mod;
        }
        else if(last=='i'){
             if(dp[2][len]!=-1){
                return dp[2][len]%mod;
            }
            cnt=(cnt+backtrack(len+1,last='a',n)%mod+backtrack(len+1,last='e',n)%mod+
                backtrack(len+1,last='o',n)%mod+backtrack(len+1,last='u',n)%mod)%mod;
            dp[2][len]=(int)cnt%mod;
        }
        else if(last=='o'){
             if(dp[3][len]!=-1){
                return dp[3][len]%mod;
            }
             cnt=(cnt+backtrack(len+1,last='i',n)%mod+backtrack(len+1,last='u',n)%mod)%mod;
            dp[3][len]=(int)cnt%mod;
        }
        else{
             if(dp[4][len]!=-1){
                return dp[4][len]%mod;
            }
            cnt=(cnt+backtrack(len+1,last='a',n))%mod;
            dp[4][len]=(int)cnt%mod;
        }
        return (int)cnt%mod;
    }
    public int countVowelPermutation(int n) {
        dp=new int[6][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return backtrack(0,'z',n)%mod;
    }
}