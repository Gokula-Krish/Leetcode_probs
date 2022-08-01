class Solution {
    public void dfs(boolean[] visited,List<List<Integer>> rooms,int src){
        visited[src]=true;
        for(int l:rooms.get(src)){
            if(!visited[l]){
                dfs(visited,rooms,l);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.get(0).size()==0){
            return false;
        }
        boolean[] visited=new boolean[rooms.size()];
        dfs(visited,rooms,0);
        for(boolean bool:visited){
            if(!bool){
                return bool;
            }
        }
        return true;
    }
}