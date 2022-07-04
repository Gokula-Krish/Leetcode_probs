class Solution {
    public int candy(int[] ratings) {
        int[] L2R=new int[ratings.length];
        int[] R2L=new int[ratings.length];
        L2R[0]=1;
        R2L[ratings.length-1]=1;
        for(int i=1;i<ratings.length;i++){
              if(ratings[i-1]<ratings[i]){
                  L2R[i]+=L2R[i-1]+1;
              }
              else{
                  L2R[i]=1;
              }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                R2L[i]+=R2L[i+1]+1;
            }
            else{
                R2L[i]=1;
            }
        }
        int sum=0;
        for(int i=0;i<ratings.length;i++){
            sum+=Math.max(L2R[i],R2L[i]);
        }
        return sum;
    }
}