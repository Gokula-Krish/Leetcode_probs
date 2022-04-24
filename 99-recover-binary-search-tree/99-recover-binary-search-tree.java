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
    ArrayList<TreeNode> ls=new ArrayList();
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        ls.add(root);
        inOrder(root.right);
    }
    public void recoverTree(TreeNode root) {
        TreeNode n1=null,n2=null,prev=new TreeNode(-11111);
        inOrder(root);
        int n=ls.size();
        for(int i=0;i<n;i++){
            if(i==0){
                if(ls.get(i).val>ls.get(i+1).val){
                    n1=ls.get(i);
                }
            }
            else if(i==n-1){
                if(ls.get(i).val<ls.get(i-1).val){
                    n2=ls.get(i);
                }
            }
            else{
                if(ls.get(i).val<ls.get(i-1).val && ls.get(i).val<ls.get(i+1).val){
                    if(n1==null){
                        n1=ls.get(i);
                    }
                    n2=ls.get(i);
                }
                else if(ls.get(i).val>ls.get(i-1).val && ls.get(i).val>ls.get(i+1).val){
                    if(n1==null){
                        n1=ls.get(i);
                    }
                    n2=ls.get(i);
                }
            }
        }
        if(n1!=null && n2!=null){
            int t=n1.val;
            n1.val=n2.val;
            n2.val=t;
        }
    }
}