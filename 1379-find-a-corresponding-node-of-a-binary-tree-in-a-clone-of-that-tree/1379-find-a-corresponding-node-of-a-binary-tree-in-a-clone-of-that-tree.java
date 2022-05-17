/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans=null;
    public void preOrder(TreeNode root,TreeNode tar){
        if(root==null){
            return;
        }
        if(tar.val==root.val){
            ans=root;
            return;
        }
        if(ans!=null){
            return;
        }
        preOrder(root.left,tar);
        preOrder(root.right,tar);
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned==null){
            return cloned;
        }
        preOrder(cloned,target);
        return ans;
    }
}