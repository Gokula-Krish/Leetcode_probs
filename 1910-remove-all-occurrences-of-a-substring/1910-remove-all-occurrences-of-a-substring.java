class Solution {
    public String removeOccurrences(String s, String part) {
       StringBuilder sb=new StringBuilder();
        int n=part.length();
        for(char c:s.toCharArray()){
            sb.append(c);
            if(sb.length()>=n && (sb.substring(sb.length()-n).toString().equals(part))){
                int i=0;
                while(i<n){
                    sb.deleteCharAt(sb.length()-1);
                    i++;
                }
            }
        }
        return sb.toString();
    }
}