class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack=new Stack();
        int n=part.length();
        for(char c:s.toCharArray()){
            stack.push(c);
            if(stack.size()>=n){
                int i=n-1;
                Stack<Character> stack1=new Stack();
                stack1.addAll(stack);
                while(!stack.empty() && i>=0 && stack.peek()==part.charAt(i)){
                    stack.pop();i--;
                }
                if(i!=-1){
                    stack=stack1;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return new String(sb.reverse());
    }
}