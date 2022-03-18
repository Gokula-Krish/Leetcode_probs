class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count=new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        Stack<Character> stack=new Stack();
        boolean[] inSt=new boolean[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            count[c-'a']--;
            while(!stack.empty() && count[stack.peek()-'a']>0 && stack.peek()>c && !inSt[c-'a']){
                char a=stack.pop();
                inSt[a-'a']=false;
            }
            if(!inSt[c-'a']){
                stack.push(c);
                inSt[c-'a']=true;  
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}