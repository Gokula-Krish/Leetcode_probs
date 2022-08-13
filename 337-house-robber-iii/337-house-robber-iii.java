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
    public int[] help(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] left=help(root.left);
        int[] right=help(root.right);
        int Root=root.val+left[1]+right[1];
        int notRoot=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{Root,notRoot};
    }
    public int rob(TreeNode root) {
        int[] ans=help(root);
        return Math.max(ans[0],ans[1]);
    }
}