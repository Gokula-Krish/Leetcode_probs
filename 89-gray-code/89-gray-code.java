class Solution {
    ArrayList<Integer> ls=new ArrayList();
    HashSet<String> set=new HashSet();
    public void backtrack(char[] arr,int n){
        if(set.contains(new String(arr))){
            return;
        }
        if(ls.size()>=(Math.pow(2,n))){
            return;
        }
        String s=new String(arr);
        set.add(s);
        ls.add(Integer.parseInt(s,2));
        for(int i=n-1;i>=0;--i){
            char c=arr[i];
            if(c=='0'){
                arr[i]='1';
                backtrack(arr,n);
            }
            arr[i]=c;
        }
    }
    public List<Integer> grayCode(int n) {
        String str="";
        for(int i=0;i<n;i++){
            str+="0";
        }
        backtrack(str.toCharArray(),n);
        return ls;
    }
}