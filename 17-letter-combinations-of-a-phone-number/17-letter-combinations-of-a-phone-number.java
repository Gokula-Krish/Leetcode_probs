class Solution {
    static String[] phone={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void letterCombine(List<String> res,String digits,String curr,int in){
        if(in==digits.length()){
            res.add(curr);
            return;
        }
        String letters=phone[digits.charAt(in)-'0'];
        for(int i=0;i<letters.length();i++){
            letterCombine(res,digits,curr+letters.charAt(i),in+1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<String>();
        if(digits.length()==0){
            return res;
        }   
        letterCombine(res,digits,"",0);
        return res;
    }
}