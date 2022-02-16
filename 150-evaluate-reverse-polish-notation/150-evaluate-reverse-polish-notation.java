class Solution {
    public int evaluate(String s,int a,int b){
        if(s.equals("+")){
            return a+b;
        }
        else if(s.equals("-")){
            return a-b;
        }
        else if(s.equals("*")){
            return a*b;
        }
        else if(s.equals("/")){
            return a/b;
        }
        return 0;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack();
        for(String s:tokens){
            if(isExp(s)){
                if(!stack.empty()){
                    int b=stack.pop();
                    int a=stack.pop();
                    int c=evaluate(s,a,b);
                    stack.push(c);
                }
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    public boolean isExp(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}