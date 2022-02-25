class Solution {
    public int compareVersion(String s1, String s2) {
        s1=s1.replace('.',' ');
        s2=s2.replace('.',' ');
        String[] st1=s1.split(" ");
        String[] st2=s2.split(" ");int n=st1.length>st2.length?st1.length:st2.length;
        int[] a=new int[n];int[] b=new int[n];
        for(int i=0;i<st1.length;i++){
            a[i]=Integer.parseInt(st1[i]);
        }
        for(int i=0;i<st2.length;i++){
            b[i]=Integer.parseInt(st2[i]);
        }
        ArrayList<Integer> ls=new ArrayList<Integer>();
        int n1=a.length<b.length?a.length:b.length;
        for(int i=0;i<n1;i++){
            if(a[i]>b[i]){
                ls.add(1);
            }
            else if(a[i]==b[i]){
                ls.add(0);
            }
            else if(a[i]<b[i]){
                ls.add(-1);
            }
        }int f=-1;
        for(int i=0;i<n1;i++){
            if(ls.get(i)!=0){
                f=1;
                return ls.get(i);
            }
        }
        if(f==-1){
            return 0;
        }
        return 0;
    }
}