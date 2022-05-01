class Solution {
    public Stack<Character> check(String S){
        Stack<Character> stack=new Stack();
        for(char c:S.toCharArray()){
            if(Character.isAlphabetic(c)){
                stack.push(c);
            }
            else if(c=='#' && !stack.empty()){
                stack.pop();
            }
        }
        return stack;
    }
    public boolean backspaceCompare(String s, String t) {
        return check(s).equals(check(t));
    }
}