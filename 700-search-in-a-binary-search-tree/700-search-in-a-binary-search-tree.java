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
    TreeNode node=null;
    public boolean contains(TreeNode root,int val){
        if(root==null){
            return false;
        }
        if(root.val==val){
            node=root;
        }
        return root.val==val || contains(root.left,val) || contains(root.right,val);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(contains(root,val)){
            return node;
        }
        return node;
    }
}