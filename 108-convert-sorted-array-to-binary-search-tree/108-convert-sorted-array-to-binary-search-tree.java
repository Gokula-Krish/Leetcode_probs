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
    public TreeNode sortedArrayToBST(int[] nums) {
        return binarySearchTree(root,nums,0,nums.length-1);
    }
    public TreeNode binarySearchTree(TreeNode root,int[] nums,int s,int e){
        if(s>e){
            return null;
        }
        int mid=(s+e)/2;
        root=new TreeNode(nums[mid]);
        root.left=binarySearchTree(root.left,nums,s,mid-1);
        root.right=binarySearchTree(root.right,nums,mid+1,e);
        return root;
    }
}