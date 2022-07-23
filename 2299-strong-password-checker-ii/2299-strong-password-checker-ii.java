class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8){
            return false;
        }
        int[] check=new int[4];
        char[] arr=password.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(i<arr.length-1){
                if(arr[i]==arr[i+1]){
                    return false;
                }
            }
            if(Character.isUpperCase(arr[i])){check[0]++;}
            else if(Character.isLowerCase(arr[i])){check[1]++;}
            else if(Character.isDigit(arr[i])){check[2]++;}
            else{check[3]++;}
        }
        return check[0]>=1 && check[1]>=1 && check[2]>=1 && check[3]>=1;
    }
}