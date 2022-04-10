class Solution {
    public boolean isInt(String s){
        try{
            int a=Integer.parseInt(s);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    public int calPoints(String[] ops) {
        int total=0;
        Stack<Integer> stack=new Stack();
        for(String s:ops){
            if(isInt(s)){
                stack.push(Integer.parseInt(s));
            }
            else if(s.equals("C")){
                stack.pop();
            }
            else if(s.equals("D")){
                int a=stack.peek();
                stack.push(2*a);
            }
            else{
                int a=stack.pop();
                int b=stack.pop();
                int c=a+b;
                stack.push(b);
                stack.push(a);
                stack.push(c);
            }
        }
        while(!stack.empty()){
            total+=stack.pop();
        }
        return total;
    }
}