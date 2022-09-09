class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int c=0,max=Integer.MIN_VALUE;
        for(int i=properties.length-1;i>=0;i--){
            if(max>properties[i][1]){
                c++;
            }
            max=Math.max(max,properties[i][1]);
        }
        return c;
    }
}