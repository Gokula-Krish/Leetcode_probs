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
    ArrayList<Integer> ls=new ArrayList<>();
    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        ls.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        preOrder(root);
        root.left=null;
        for(int i=1;i<ls.size();i++){
            root.right=new TreeNode(ls.get(i));
            root=root.right;
        }
    }
}