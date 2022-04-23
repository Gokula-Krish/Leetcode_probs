/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val+sum(root.left)+sum(root.right);
    }
    public void preOrder(TreeNode root,LinkedHashMap<Integer,Integer> lh){
        if(root==null){
            return;
        }
        int sum=sum(root);
        lh.put(sum,lh.getOrDefault(sum,0)+1);
        preOrder(root.left,lh);
        preOrder(root.right,lh);
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null){
            int[] ans=new int[1];
            return ans;
        }
        LinkedHashMap<Integer,Integer> lh=new LinkedHashMap();
        preOrder(root,lh);
        int max=Integer.MIN_VALUE;
        for(Map.Entry m:lh.entrySet()){
            max=Math.max(max,(int)m.getValue());
        }
        ArrayList<Integer> ls=new ArrayList();
        for(Map.Entry m:lh.entrySet()){
            if((int)m.getValue()==max){
                ls.add((int)m.getKey());
            }
        }
        int[] ans=new int[ls.size()];
        for(int i=0;i<ls.size();i++){
            ans[i]=ls.get(i);
        }
        return ans;
    }
}