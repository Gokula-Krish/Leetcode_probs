class Solution {
    public int minAddToMakeValid(String s) {
        int count=0;
        Stack<Character> stack=new Stack();
        for(char c:s.toCharArray()){
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