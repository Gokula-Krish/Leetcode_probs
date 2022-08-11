class Solution {
    public boolean isAny(char c){
        return (!Character.isAlphabetic(c) && !Character.isDigit(c)) || Character.isDigit(c);
    }
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack();
        StringBuilder sb=new StringBuilder();
        StringBuilder dot=new StringBuilder(".");
        StringBuilder dot2=new StringBuilder("..");
        int n=0;
        for(char c:path.toCharArray()){
            if(c!='/' && (Character.isAlphabetic(c) || isAny(c))){
                sb.append(c);
                n++;
            }
            else if(c=='/' && n>0){
                if(sb.compareTo(dot2)==0){
                    if(!stack.empty())
                        stack.pop();
                }
                else if(!(sb.compareTo(dot)==0)){
                    stack.push(sb.toString());
                }
                sb=new StringBuilder();
                n=0;
            }
        }
        if(n>0 && sb.compareTo(dot2)==0){
            if(!stack.empty())stack.pop();
        }
        else if(n>0 && !(sb.compareTo(dot)==0)){
            stack.push(sb.toString());
        }
        String str="";
        while(!stack.empty()){
            str="/"+stack.pop()+str;
        }
        if(str.isEmpty()){
            return "/";
        }
        return str;
    }
}