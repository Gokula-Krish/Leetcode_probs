class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean[] visited=new boolean[n];
        Stack<Integer> stack=new Stack();
        stack.push(start);
        while(!stack.empty()){
            int top=stack.pop();
            if(arr[top]==0){
                return true;
            }
            int s=top-arr[top];
            int e=top+arr[top];
            visited[top]=true;
            if(s>=0 && !visited[s]){
                stack.push(s);
            }
            if(e<n && !visited[e]){
                stack.push(e);
            }
        }
        return false;
    }
}