class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack=new Stack();
        int n=part.length(),stsize=0;
        for(char c:s.toCharArray()){
            stack.push(c);
            stsize++;
            if(stsize>=n){
                int i=n-1;
                Stack<Character> stack1=new Stack();
                stack1.addAll(stack);
                while(stsize>0 && i>=0 && stack.peek()==part.charAt(i)){
                    stack.pop();i--;
                    stsize--;
                }
                if(i!=-1){
                    stack=stack1;
                    stsize=stack.size();
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