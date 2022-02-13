class Solution {
    public boolean isValid(String s) {
        Stack<Character> S=new Stack<>();int n=s.length();
        if(n%2!=0){
            return false;
        }
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                S.push(s.charAt(i));
            }
            else if(s.charAt(i)==')' && !S.empty() && S.peek()=='('){
                S.pop();
            }
            else if(s.charAt(i)=='}' && !S.empty() && S.peek()=='{'){
                S.pop();
            }
            else if(s.charAt(i)==']' && !S.empty() && S.peek()=='['){
                S.pop();
            }
            else{
                return false;
            }
        }
        return S.empty();
    }
}