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
    List<TreeNode> ls=new ArrayList();
    HashSet<String> set=new HashSet();
    HashMap<String,TreeNode> map=new HashMap();
    public String preOrder(TreeNode root,int l){
        if(root==null){
            return "N";
        }
        String left=preOrder(root.left,l+1);
        String right=preOrder(root.right,l+1);
        String str=root.val+","+left+","+right;
        if(map.containsKey(str) && !set.contains(str)){
            ls.add(root);
            set.add(str);
        }
        map.put(str,root);
        return str;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preOrder(root,0);
        return ls;
    }
}