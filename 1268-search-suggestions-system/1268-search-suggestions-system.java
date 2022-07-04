class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                return s1.compareTo(s2);
            }
        });
        int l=0,r=products.length-1;
        List<List<String>> ans=new ArrayList();
        for(int i=0;i<searchWord.length();i++){
            char c=searchWord.charAt(i);
            while(l<=r && (i>=products[l].length() || c!=products[l].charAt(i))){
                l++;
            }
            while(l<=r && (i>=products[r].length()  || c!=products[r].charAt(i))){
                r--;
            }
            List<String> aux=new ArrayList();
            if((r-l)>=3){
                for(int k=l;k<l+3;k++){
                    aux.add(products[k]);
                }
            }
            else{
                for(int k=l;k<=r;k++){
                    aux.add(products[k]);
                }
            }
            ans.add(aux);
        }
        return ans;
    }
}