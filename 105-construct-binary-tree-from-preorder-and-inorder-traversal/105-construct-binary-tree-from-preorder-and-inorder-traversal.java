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
    TreeNode root=null;
    int i=0;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(TreeNode root,int[] preorder,int[] inorder,int l,int r){
        if(l>r){
            return null;
        }
        int p=preorder[i];
        root=new TreeNode(p);i++;
        root.left=buildTree(root.left,preorder,inorder,l,map.get(p)-1);
        root.right=buildTree(root.right,preorder,inorder,map.get(p)+1,r);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(root,preorder,inorder,0,inorder.length-1);
    }
}