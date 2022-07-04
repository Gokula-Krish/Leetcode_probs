class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum=Integer.MAX_VALUE;
        int in=0;
        for(int i=1;i<triangle.size();i++){
            int n=triangle.get(i).size();
            for(int j=0;j<n;j++){
                if(j==0){
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j));
                }
                else if(j==n-1){
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
                }
                else{
                    int a=triangle.get(i).get(j)+triangle.get(i-1).get(j);
                    int b=triangle.get(i).get(j)+triangle.get(i-1).get(j-1);
                    triangle.get(i).set(j,Math.min(a,b));
                }
            }
        }
        for(int l:triangle.get(triangle.size()-1)){
            sum=Math.min(sum,l);
        }
        return sum;
    }
}