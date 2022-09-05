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
    List<Integer> ls=new ArrayList();
    int j;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        j=0;
        dfs(root,voyage.length,voyage);
        return ls;
    }
    boolean added=false;
    public void dfs(TreeNode root,int n,int[] arr){
        if(root==null)return;
        if(root.val!=arr[j]){
            ls.clear();
            ls.add(-1);
            added=true;
            return;
        }j++;
        if(added)return;
        if(j<n && root.left!=null && root.left.val!=arr[j]){
            ls.add(root.val);
            dfs(root.right,n,arr);
            dfs(root.left,n,arr);
        }
        else{
            dfs(root.left,n,arr);
            dfs(root.right,n,arr);
        }
    }
}