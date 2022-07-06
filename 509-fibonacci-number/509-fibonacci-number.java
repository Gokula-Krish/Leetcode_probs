class Solution {
    HashMap<Integer,Integer> map=new HashMap();
    public int fib(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n==2 || n==1){
            return 1;
        }
        if(n<=0){
            return 0;
        }
        int f=fib(n-1)+fib(n-2);
        map.put(n,f);
        return f;
    }
}