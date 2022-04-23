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
    public String tree2str(TreeNode root) {
        if(root==null){
            return "";
        }
        String l1=tree2str(root.left);
        String l2=tree2str(root.right);
        String str=root.val+"";
        if(l1.equals("") && !l2.equals("")){
            str+="()"+"("+l2+")";
            return str;
        }
        if(!l1.equals("")){
            str+="("+l1+")";
        }
        if(!l2.equals("")){
            str+="("+l2+")";
        }
        
        return str;
    }
}