class Solution {
    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> set=new HashSet();
        boolean[] visited=new boolean[arr.length];
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
            if(e<arr.length && !visited[e]){
                stack.push(e);
            }
        }
        return false;
    }
}