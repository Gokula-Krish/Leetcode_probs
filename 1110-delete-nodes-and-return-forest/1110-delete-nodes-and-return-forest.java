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
    HashSet<Integer> set=new HashSet();
    ArrayList<TreeNode> forests=new ArrayList();
    public boolean delete(TreeNode root){
        if(root==null){
            return false;
        }
        boolean left=delete(root.left);
        boolean right=delete(root.right);
        if(left){
            root.left=null;
        }
        if(right){
            root.right=null;
        }
        if(set.contains(root.val)){
            if(root.left!=null){
                forests.add(root.left);
            }
            if(root.right!=null){
                forests.add(root.right);
            }
            root=null;
            return true;
        }
        return false;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int i:to_delete){
            set.add(i);
        }
        boolean ans=delete(root);
        if(!ans && root!=null){
            forests.add(root);
        }
        return forests;
    }
}