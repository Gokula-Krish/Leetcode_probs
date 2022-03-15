class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack=new Stack();
        boolean[] check=new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else if(!stack.empty() && s.charAt(i)==')'){
                check[i]=true;
                check[stack.pop()]=true;
            }
            else if(s.charAt(i)==')'){
                check[i]=false;
            }
            else{
                check[i]=true;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(check[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}