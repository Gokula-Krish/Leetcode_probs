class Solution {
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();        
        backTracking(s, wordDict, new ArrayList<>());        
        return res;
    }
    
    public void backTracking(String s, List<String> wordDict, List<String> pre){
        if(s.length() == 0){
            res.add(String.join(" ", pre));
            return;     
        }
        for(String str: wordDict){
            if(s.startsWith(str)){
                pre.add(str);
                backTracking(s.substring(str.length()), wordDict, pre);
                pre.remove(pre.size() - 1);
            }
        }
    }
}