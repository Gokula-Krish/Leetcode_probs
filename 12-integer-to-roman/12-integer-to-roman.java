class Solution {
    public String intToRoman(int num) {
        HashMap<Integer,String> map=new HashMap();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        String str="";
        int n=num;
        while(n>0){
            String s=String.valueOf(n);
            if(map.containsKey(n)){
                str+=map.get(n);
                n-=n;
            }
            else if(s.length()==1 && s.charAt(0)=='4'){
                str+="IV";
                n-=4;
            }
            else if(s.length()==2 && s.charAt(0)=='4'){
                str+="XL";
                n-=40;
            }
            else if(s.length()==3 && s.charAt(0)=='4'){
                str+="CD";
                n-=400;
            }
            else if(s.length()==1 && s.charAt(0)=='9'){
                str+="IX";
                n-=9;
            }
            else if(s.length()==2 && s.charAt(0)=='9'){
                str+="XC";
                n-=90;
            }
            else if(s.length()==3 && s.charAt(0)=='9'){
                str+="CM";
                n-=900;
            }
            else if(n<4){
                str+=map.get(1);
                n-=1;
            }
            else if(n<4){
                str+="I";
                n-=1;
            }
            else if(n<10){
                str+="V";
                n-=5;
            }
            else if(n<50){
                str+="X";
                n-=10;
            }
            else if(n<100){
                str+="L";
                n-=50;
            }
            else if(n<500){
                str+="C";
                n-=100;
            }
            else if(n<1000){
                str+="D";
                n-=500;
            }
            else{
                str+="M";
                n-=1000;
            }
        }
        return str;
    }
}