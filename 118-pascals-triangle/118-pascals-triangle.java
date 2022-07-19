class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls=new ArrayList();
        ls.add(new ArrayList());
        ls.get(0).add(1);
        if(numRows==1){
            return ls;
        }
       // ls.add(new ArrayList());
        for(int i=1;i<numRows;i++){
            ls.add(new ArrayList());
            for(int j=0;j<i+1;j++){
                if(j==0){
                    ls.get(i).add(1);
                }
                else if(j==i){
                    ls.get(i).add(1);
                }
                else{
                    ls.get(i).add(ls.get(i-1).get(j-1)+ls.get(i-1).get(j));
                }
            }
        }
        return ls;
    }
}