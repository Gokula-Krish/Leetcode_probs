class Solution {
    public boolean isAny(char c){
        return (!Character.isAlphabetic(c) && !Character.isDigit(c)) || Character.isDigit(c);
    }
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack();
        StringBuilder sb=new StringBuilder();
        for(char c:path.toCharArray()){
            if(c!='/' && (Character.isAlphabetic(c) || isAny(c))){
                sb.append(c);
            }
            else if(c=='/' && sb.length()>0){
                if(sb.toString().equals("..")){
                    if(!stack.empty())
                        stack.pop();
                }
                else if(!sb.toString().equals(".")){
                    stack.push(sb.toString());
                }
                sb=new StringBuilder();
            }
        }
        if(!sb.isEmpty() && sb.toString().equals("..")){
            if(!stack.empty())stack.pop();
            sb=new StringBuilder();
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