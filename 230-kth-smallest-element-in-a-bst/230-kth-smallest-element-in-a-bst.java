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
    int c=1;TreeNode ans=null;
    public void inOrder(TreeNode root,int k){
        if(root==null){
            return;
        }
        inOrder(root.left,k);
        if(c==k && ans==null){
            ans=root;
        }c++;
        inOrder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans.val;
    }
}