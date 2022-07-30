class Solution {
    public int minAddToMakeValid(String s) {
        int count=0,size=0;
        Stack<Character> stack=new Stack();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(c);
                size++;
            }
            else if(c==')' && size>0 && stack.peek()=='('){
                stack.pop();
                size--;
            }
            else if(c==')' && size==0){
                count++;
            }
        }
        return count+size;
    }
}