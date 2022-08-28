class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        LinkedList<Integer> list[]=new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            list[i]=new LinkedList();
        }
        for(int[] arr:dislikes){
            list[arr[0]].add(arr[1]);
            list[arr[1]].add(arr[0]);
        }
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(!dfs(list,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(LinkedList<Integer> list[],int src,int[] color){
        if(color[src]==-1)color[src]=1;
        for(int i:list[src]){
            if(color[i]==-1){
                color[i]=1-color[src];
                if(!dfs(list,i,color)){
                    return false;
                }
            }
            else if(color[src]==color[i]){
                return false;
            }
        }
        return true;
    }
}