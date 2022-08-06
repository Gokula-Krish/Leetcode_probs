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
        while(!q.isEmpty()){
            int n=q.size();
            int count=0;
            ans=true;
            nochild=false;
            while(n-->0){
                TreeNode c=q.poll();
                if(!ans && c.left!=null){
                    return false;
                }
                if(!ans && c.right!=null){
                    return false;
                }
                if(c.left==null){
                    ans=false;
                }
                if(!ans && c.right!=null){
                    return false;
                }
                if(c.right==null){
                    ans=false;
                }
                if(c.left!=null){
                    nochild=true;
                    q.add(c.left);
                }
                if(c.right!=null){
                    nochild=true;
                    q.add(c.right);
                }
                count++;
            }
            int l=(int)Math.pow(2,level);
            if(count!=l && nochild){
                return false;
            }level++;
        }
        return true;
    }
}