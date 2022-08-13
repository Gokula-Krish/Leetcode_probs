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
    public int preOrder(TreeNode root,int l){
        if(root==null){
            return 0;
        }
        int left=preOrder(root.left,l+1);
        int right=preOrder(root.right,l+1);
        if(left==right && left+l>=max){
            res=root;
            max=l+left;
        }
        return 1+Math.max(left,right);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        preOrder(root,0);
        return res;
    }
    TreeNode res=null;int max=0;
}