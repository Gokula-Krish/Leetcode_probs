class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return b[1]-a[1];
            }
        });
        int sum=0;
        for(int[] a:boxTypes){
            if(a[0]<=truckSize){
                sum+=(a[0]*a[1]);
                truckSize-=a[0];
            }
            else{
                sum+=(truckSize*a[1]);
                truckSize=0;
            }
        }
        return sum;
    }
}