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
    ArrayList<Integer> ls=new ArrayList();
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }inOrder(root.left);
        ls.add(root.val);
        inOrder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        for(int i=0;i<ls.size()-1;i++){
            if(ls.get(i)>=ls.get(i+1)){
                return false;
            }
        }
        return true;
    }
}