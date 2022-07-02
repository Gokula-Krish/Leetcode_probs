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
    public boolean isSorted(ArrayList<Integer> ls){
        for(int i=0;i<ls.size()-1;i++){
            if(ls.get(i)>=ls.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public void inOrder(TreeNode root,ArrayList<Integer> l){
        if(root==null){
            return;
        }
        inOrder(root.left,l);
        l.add(root.val);
        inOrder(root.right,l);
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        ArrayList<Integer> ls=new ArrayList<>();
        inOrder(root,ls);
        return isSorted(ls);
    }
}