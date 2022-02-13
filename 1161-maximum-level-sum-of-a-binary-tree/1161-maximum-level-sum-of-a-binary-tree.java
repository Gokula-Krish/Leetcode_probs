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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        int max=Integer.MIN_VALUE;
        int i=0;
        int lev=i;
        while(!q.isEmpty()){
            i++;  
            int n=q.size();            
            int s=0;
            while(n-->0){
                TreeNode c=q.poll();
                s+=c.val;
                if(c.left!=null){
                    q.add(c.left);
                }
                if(c.right!=null){
                    q.add(c.right);
                }
            }        
            if(s>max){
                max=s;
                lev=i;
            }
        }
        return lev;
    }
}