class Solution {
    public int minAddToMakeValid(String s) {
        int count=0;
        Stack<Character> stack=new Stack();
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(c);
            }
            else if(c==')' && !stack.empty() && stack.peek()=='('){
                stack.pop();
            }
            else if(c==')' && stack.empty()){
                count++;
            }
        }
        return count+stack.size();
    }
}