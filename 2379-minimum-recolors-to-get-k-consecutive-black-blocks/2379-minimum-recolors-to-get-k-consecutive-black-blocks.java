class Solution {
    public int minimumRecolors(String blocks, int k) {
        if(blocks.length()<k){
            return -1;
        }
        int[] count=new int[58];
        int[] count1=new int[58];
        count['B'-'A']=k;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            count1[blocks.charAt(i)-'A']++;
        } 
        for(int i=0;i<blocks.length()-k;i++){
            if(Arrays.equals(count,count1)){
                return 0;
            }
            else{
                min=Math.min(min,Math.abs(count['B'-'A']-count1['B'-'A']));
            }
            count1[blocks.charAt(i)-'A']--;
            count1[blocks.charAt(i+k)-'A']++;
        }
        if(Arrays.equals(count,count1)){
            return 0;
        }
        else{
            min=Math.min(min,Math.abs(count['B'-'A']-count1['B'-'A']));
        }
        return min;
    }
}