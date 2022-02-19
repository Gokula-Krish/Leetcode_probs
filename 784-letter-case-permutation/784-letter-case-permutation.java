class Solution {
    List<String> ans=new ArrayList();
    boolean lastUp=false,lastLow=false;
    HashMap<String,Integer> map=new HashMap();
    public void recursion(String str,int i){
        if(str.length()==i){
            if(!map.containsKey(str)){
                ans.add(str);
                map.put(str,i);
             }
            return;
        }
        recursion(str,i+1);
        StringBuilder sb=new StringBuilder(str);
        if(Character.isLowerCase(sb.charAt(i))){
            sb.setCharAt(i,(char)(sb.charAt(i)-32));
        }
        else if(Character.isUpperCase(sb.charAt(i))){
            sb.setCharAt(i,(char)(sb.charAt(i)+32));
        }
        str=new String(sb);
        recursion(str,i+1);
    }
    public List<String> letterCasePermutation(String s) {
        recursion(s,0);
        return ans;
    }
}