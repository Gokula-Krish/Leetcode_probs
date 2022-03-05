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
    TreeNode ans=null;
    boolean bool=false;
    public void preOrder(TreeNode root,TreeNode sub){
        if(root==null){
            return;
        }
        if(root.val==sub.val){
            ans=root;
            boolean dum=isEqual(root,sub);
            if(dum){
                bool=dum;
            }
        }
        preOrder(root.left,sub);
        preOrder(root.right,sub);
    }
    public boolean isEqual(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        return (root1.val==root2.val) && isEqual(root1.left,root2.left) && isEqual(root1.right,root2.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        preOrder(root,subRoot);
        return bool;
    }
}