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
    TreeNode root1=new TreeNode(-1111);
    TreeNode temp=root1;
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        temp.right=new TreeNode(root.val);
        temp=temp.right;
        inOrder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return root1.right;
    }
}