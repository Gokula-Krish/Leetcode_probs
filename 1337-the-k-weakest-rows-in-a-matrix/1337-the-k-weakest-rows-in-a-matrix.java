class Solution {
    class Pair{
        int rowNo,rowStren;
        Pair(int rowNo,int rowStren){
            this.rowNo=rowNo;
            this.rowStren=rowStren;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans=new int[k];
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>(new Comparator<Pair>(){
           @Override
            public int compare(Pair p1,Pair p2){
                if(p1.rowStren>p2.rowStren){
                    return 1;
                }
                else if(p1.rowStren<p2.rowStren){
                    return -1;
                }
                else{
                    if(p1.rowNo>p2.rowNo){
                        return 1;
                    }
                    else if(p1.rowNo<p2.rowNo){
                        return -1;
                    }
                    return 0;
                }
            }
        });
        for(int i=0;i<mat.length;i++){
            int c=0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1){
                    c++;
                }
            }
            pq.add(new Pair(i,c));
        }
        int j=0;
        for(int i=0;i<k;i++){
            Pair p=pq.poll();
            ans[j++]=p.rowNo;
        }
        return ans;
    }
}