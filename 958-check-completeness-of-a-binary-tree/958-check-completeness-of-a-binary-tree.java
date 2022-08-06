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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        int level=0;
         boolean ans=true,nochild=false;
        TreeNode nodes=new TreeNode(-11);
        while(!q.isEmpty()){
            int n=q.size();
            int count=0;
            ans=true;
            if(nodes==null){
                return false;
            }
            nochild=false;
            while(n-->0){
                TreeNode c=q.poll();
                nodes=c;
                if(c.left!=null){
                    if(!ans){return false;}
                    nochild=true;
                    q.add(c.left);
                }
                else{
                    ans=false;
                }
                if(c.right!=null){
                    if(!ans){return false;}
                    nochild=true;
                    q.add(c.right);
                }
                else{
                    ans=false;
                }
                count++;
            }
            int l=(int)Math.pow(2,level);
            if(count!=l && nochild){
                return false;
            }
            level++;
        }
        return true;
    }
}