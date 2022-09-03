class Solution {
    List<Integer> list=new LinkedList();
    public void backTrack(int num,int n,int k,int c){
        if(c==n){
            list.add(num);
            return;
        }
        for(int i=0;i<=9;i++){
            int abs=Math.abs(num%10-i);
            if(abs==k){
                backTrack((num*10+i),n,k,c+1);
            }
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i=1;i<=9;i++){
            backTrack(i,n,k,1);
        }
        int[] arr=new int[list.size()];
        int index=0;
        for(int i:list){
            arr[index++]=i;
        }
        return arr;
    }
}