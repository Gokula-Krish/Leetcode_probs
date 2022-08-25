class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> list=new ArrayList();
        int[] indegree=new int[n];
        for(List<Integer> L:edges){
            indegree[L.get(1)]++;
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                list.add(i);
            }
        }
        return list;
    }
}