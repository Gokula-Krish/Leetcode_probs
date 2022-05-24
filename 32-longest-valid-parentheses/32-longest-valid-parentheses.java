class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> S=new Stack<>();
        int n=s.length();int max=0;
        S.push(-1);
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                S.push(i);
            }
            else{
                S.pop();
                if(S.empty()){
                    S.push(i);
                }
                else{
                    max=Math.max(max,i-S.peek());
                }
            }
        }
        return max;
    }
}