class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1=new Stack();
        Stack<Character> stack2=new Stack();
        for(char c:s.toCharArray()){
            if(Character.isAlphabetic(c)){
                stack1.push(c);
            }
            else if(c=='#' && !stack1.empty()){
                stack1.pop();
            }
        }
        for(char c:t.toCharArray()){
            if(Character.isAlphabetic(c)){
                stack2.push(c);
            }
            else if(c=='#' && !stack2.empty()){
                stack2.pop();
            }
        }
        return stack1.equals(stack2);
    }
}