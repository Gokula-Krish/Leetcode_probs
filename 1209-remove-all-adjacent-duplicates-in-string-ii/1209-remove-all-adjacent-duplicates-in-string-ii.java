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
        //int c=1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(stack.empty()){
                stack.push(new Pair(ch,1));
            }
            else if(stack.peek().val!=ch){
                stack.push(new Pair(ch,1));
            }
            else if(stack.peek().val==ch){
                int c=stack.peek().count+1;
                stack.push(new Pair(ch,c));
                c++;
                c=k%c;
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