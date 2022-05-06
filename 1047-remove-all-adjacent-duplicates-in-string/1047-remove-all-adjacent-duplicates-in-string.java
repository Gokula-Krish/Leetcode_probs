class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack=new Stack();
        for(char c:s.toCharArray()){
            if(stack.empty()){
                stack.push(c);
            }
            else if(stack.peek()==c){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        String str="";
        while(!stack.empty()){
            str=stack.pop()+str;
        }
        return str;
    }
}