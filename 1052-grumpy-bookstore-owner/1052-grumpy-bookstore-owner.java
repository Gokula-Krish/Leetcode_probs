class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum=0,n=customers.length;
        for(int i=minutes;i<n;i++){
            if(grumpy[i]==0)sum+=customers[i];
        }
        int maxG=0;
        for(int i=0;i<minutes;i++){
            maxG+=customers[i];
        }
      //  System.out.println(maxG+"====="+sum);
        int max=0;
        for(int i=0;i<n-minutes;i++){
            max=Math.max(maxG+sum,max);
            maxG+=customers[i+minutes];
            maxG-=customers[i];
            if(grumpy[i]==0){
                sum+=customers[i];
            }
            if(grumpy[i+minutes]==0){
                sum-=customers[i+minutes];
            }
            //sum-=customers[i+minutes];
           // System.out.println(maxG+"----"+sum);
        }
         max=Math.max(maxG+sum,max);
        return max;
    }
}