class Solution {
    public List<String> generateParenthesis(int n) {
        if(n==0){
            return new ArrayList();
        }
        List<String> ls=new ArrayList();
        generateParanthesis(new char[2*n],0,ls);
        return ls;
    }
    public  boolean isValid(String s){
          Stack<Character> S=new Stack<>();int n=s.length();
        if(n%2!=0){
            return false;
        }
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                S.push(s.charAt(i));
            }
            else if(s.charAt(i)==')' && !S.empty() && S.peek()=='('){
                S.pop();
            }
            else if(s.charAt(i)=='}' && !S.empty() && S.peek()=='{'){
                S.pop();
            }
            else if(s.charAt(i)==']' && !S.empty() && S.peek()=='['){
                S.pop();
            }
            else{
                return false;
            }
        }
        return S.empty();
    }
    ArrayList<String> ls=new ArrayList<>();
    public void generateParanthesis(char[] ch,int i,List<String> ls){
        if(i==ch.length){
            if(isValid(new String(ch))){
                ls.add(new String(ch));
                return;
            }
        }
        else{
            ch[i]='(';
            generateParanthesis(ch,i+1,ls);
            ch[i]=')';
            generateParanthesis(ch,i+1,ls);
        }
    }
}