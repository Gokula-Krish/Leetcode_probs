class Solution {
    public int nextGreaterElement(int n) {
        int b=n;
        LinkedList<Integer> list=new LinkedList();
        int x=0;
        while(n!=0){
            int a=n%10;
            list.addFirst(a);
            n/=10;
            x++;
        }
        int[] nums=new int[x];
        int y=0;
        for(int l1:list){
            nums[y++]=l1;
        }
        int k=-1;
        for(int i=0;i<nums.length-1;i++){
            if(list.get(i)<list.get(i+1)){
                k=i;
            }
        }
        String str="";
        if(k==-1){
            return -1;
        }
        int l=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[k]<nums[i] && i>k){
                l=i;
            }
        }
        int t=nums[l];
        nums[l]=nums[k];
        nums[k]=t;
        int s=k+1,e=nums.length-1;
        while(s<e){
            t=nums[s];
            nums[s]=nums[e];
            nums[e]=t;
            s++;e--;
        }
        str="";
        for(int a:nums){
            str+=a;
        }
        int a=-1;
        try{
            a=Integer.parseInt(str);
        }
        catch(Exception ex){return -1;}
       // System.out.println(a+"-----"+b);
        if(a<=b){
            return -1;
        }
        return a;
    }
}