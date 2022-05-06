class Solution {
    class Pair{
        char val;
        int count;
        Pair(char val,int count){
            this.val=val;
            this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack=new Stack();
        int c=1;
        for(char ch:s.toCharArray()){
            if(stack.empty()){
                stack.push(new Pair(ch,1));
            }
            else if(stack.peek().val!=ch){
                stack.push(new Pair(ch,1));
            }
            else if(stack.peek().val==ch){
                stack.push(new Pair(ch,stack.peek().count+1));
                c=stack.peek().count+1;
                c=k%c;
               // System.out.println(ch+"------"+c);
                if(c==k){
                    while(c!=0){
                        stack.pop();
                        c--;
                    }
                    
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop().val);
        }
        return new String(sb.reverse());
    }
}