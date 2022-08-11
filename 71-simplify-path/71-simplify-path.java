class Solution {
    public boolean isAny(char c){
        return (!Character.isAlphabetic(c) && !Character.isDigit(c)) || Character.isDigit(c);
    }
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack();
        StringBuilder sb=new StringBuilder();
        int n=0;
        for(char c:path.toCharArray()){
            if(c!='/' && (Character.isAlphabetic(c) || isAny(c))){
                sb.append(c);
                n++;
            }
            else if(c=='/' && n>0){
                if(sb.toString().equals("..")){
                    if(!stack.empty())
                        stack.pop();
                }
                else if(!sb.toString().equals(".")){
                    stack.push(sb.toString());
                }
                sb=new StringBuilder();
                n=0;
            }
        }
        if(!sb.isEmpty() && sb.toString().equals("..")){
            if(!stack.empty())stack.pop();
        }
        else if(!sb.isEmpty() && !sb.toString().equals(".")){
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