class Solution {
    public int nextGreaterElement(int n) {
        int b=n;
        LinkedList<Integer> list=new LinkedList();
        int x=0;
        while(n!=0){
            int a=n%10;
            list.add(0,a);
            n/=10;
            x++;
        }
        int k=-1;
        for(int i=0;i<x-1;i++){
            if(list.get(i)<list.get(i+1)){
                k=i;
            }
        }
        String str="";
        if(k==-1){
            return -1;
        }
        int l=-1;
        for(int i=0;i<x;i++){
            if(list.get(k)<list.get(i) && i>k){
                l=i;
            }
        }
        Collections.swap(list,l,k);
        int s=k+1,e=x-1;
        while(s<e){
            Collections.swap(list,s,e);
            s++;e--;
        }
        str="";
        for(int a:list){
            str+=a;
        }
        int a=-1;
        try{
            a=Integer.parseInt(str);
        }
        catch(Exception ex){return -1;}
        if(a<=b){
            return -1;
        }
        return a;
    }
}