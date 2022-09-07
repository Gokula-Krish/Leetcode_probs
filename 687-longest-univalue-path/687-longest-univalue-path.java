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
    int max=0,c=0;
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        int r1=0,l1=0;
        if(root.left!=null && root.left.val==root.val){
            l1=1+left;
        }
        if(root.right!=null && root.right.val==root.val){
            r1=1+right;
        }
        max=Math.max(l1+r1,max);
        return Math.max(l1,r1);
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }
}