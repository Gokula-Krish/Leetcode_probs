class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] sp=preorder.split(",");
        if(preorder.equals("#")){
            return true;
        }
        Stack<String> stack=new Stack();
        for(int i=0;i<sp.length;i++){
            if(sp[i].charAt(0)=='#'){
                while(stack.size()>=2 && stack.peek().charAt(0)=='#'){
                    stack.pop();
                    if(stack.peek().charAt(0)!='#')
                        stack.pop();
                }
            }
            stack.push(sp[i]);
        }
        return stack.size()==1 && stack.peek().charAt(0)=='#';
    }
}