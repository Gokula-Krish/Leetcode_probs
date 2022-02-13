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
    public void reverseInOrder(TreeNode root){
        if(root==null){
            return;
        }
        reverseInOrder(root.right);
        s+=root.val;
        root.val=s;
        reverseInOrder(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        reverseInOrder(root);
        return root;
    }
}