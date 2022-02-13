class Solution {
    HashMap<String,Integer> memo=new HashMap();
    public int uniquePaths(int m, int n) {
        String key=m+","+n;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(m==1 && n==1){
            return 1;
        }
        if(m==0 || n==0){
            return 0;
        }
        memo.put(key,uniquePaths(m-1,n)+uniquePaths(m,n-1));
        return memo.get(key);
    }
}