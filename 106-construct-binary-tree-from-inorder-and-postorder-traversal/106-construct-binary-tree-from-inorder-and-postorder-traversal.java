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
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(TreeNode root,int[] postorder,int[] inorder,int l,int r,int pl,int pr){
        if(l>r){
            return null;
        }     
        int p=postorder[pr];
        root=new TreeNode(p);
        root.left=buildTree(root.left,postorder,inorder,l,map.get(p)-1,pl,(pl+map.get(p)-1-l));
        root.right=buildTree(root.right,postorder,inorder,map.get(p)+1,r,pl+(map.get(p)-l),pr-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(null,postorder,inorder,0,inorder.length-1,0,postorder.length-1);
    }
}