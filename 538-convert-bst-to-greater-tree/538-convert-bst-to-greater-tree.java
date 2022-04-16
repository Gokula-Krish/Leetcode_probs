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
    int s=0;
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.right);
        s+=root.val;
        root.val=s;
        inOrder(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
        s=0;
        inOrder(root);
        return root;
    }
}