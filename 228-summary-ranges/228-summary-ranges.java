class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ls=new ArrayList();
        if(nums.length==0){
            return new ArrayList();
        }
        if(nums.length==1){
            ls.add(String.valueOf(nums[0]));
            return ls;
        }
        String start="",stop="";
        for(int i=0;i<nums.length-1;i++){
            if(i==0){
                start=String.valueOf(nums[i]);
            }
            if(Math.abs(nums[i]-nums[i+1])==1){}
            else{
                stop=String.valueOf(nums[i]);
                if(start.equals(stop)){
                    ls.add(start);
                }
                else{
                    ls.add(start+"->"+stop);   
                }
                start=String.valueOf(nums[i+1]);
            }
            if(i==nums.length-2){
                stop=String.valueOf(nums[i+1]);
            }
        }
        if(start.equals(stop)){
            ls.add(start);
        }
        else{
            ls.add(start+"->"+stop);
        }
        return ls;
    }
}