class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            return "0";
        }
        Stack<Integer> st=new Stack();
        int c=0;
        for(int i=0;i<num.length();i++){
            int n=num.charAt(i)-'0';
            while(!st.empty() && st.peek()>n && c<k){
                st.pop();
                c++;
            }
            st.push(n);
        }
        StringBuilder ans=new StringBuilder();
        while(c<k){
            st.pop();c++;
        }
        while(!st.empty()){
            ans.append(st.pop());
        }
        ans.reverse();
        while(ans.length()>1 && ans.charAt(0)=='0'){
            ans.deleteCharAt(0);
        }
        return ans.toString();
    }
}