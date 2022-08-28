class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,PriorityQueue<Integer>> map=new HashMap();
        int l=0;
        for(int i=0;i<mat[0].length;i++){
            map.put(i,new PriorityQueue());
            int k=0,j=i;
            while(k<mat.length && j<mat[0].length){
                map.get(i).add(mat[k][j]);
                k++;j++;
            }
        }
        l=-1;
        for(int i=1;i<mat.length;i++){
            map.put(l,new PriorityQueue());
            int k=i,j=0;
            while(k<mat.length && j<mat[0].length){
                map.get(l).add(mat[k][j]);
                k++;j++;
            }l--;
        }
        for(int i=0;i<mat[0].length;i++){
            int k=0,j=i;
            while(k<mat.length && j<mat[0].length){
                mat[k][j]=map.get(i).poll();
                k++;j++;
            }
        }
        l=-1;
        for(int i=1;i<mat.length;i++){
           // map.put(l,new PriorityQueue());
            int k=i,j=0;
            while(k<mat.length && j<mat[0].length){
                mat[k][j]=map.get(l).poll();
                k++;j++;
            }l--;
        }
        return mat;
    }
}