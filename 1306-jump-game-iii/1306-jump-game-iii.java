class Solution {
    boolean[] visited;
    int[] arr;
    private boolean dfs(int start){
        if(start < 0 || start >= arr.length)
            return false;
        
        if(arr[start] == 0)
            return true;
        
        if(visited[start])
            return false;
        
        visited[start] = true;
        
        return dfs(start + arr[start]) || dfs(start - arr[start]);
    }
    public boolean canReach(int[] arr, int start) {
        this.visited = new boolean[arr.length];
        this.arr = arr;
        return dfs(start);
    }
}