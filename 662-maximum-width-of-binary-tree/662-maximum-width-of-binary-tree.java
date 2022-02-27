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
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node,int index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<Pair> q=new LinkedList();
        q.add(new Pair(root,0));
        int ans=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int f=0,l=0;
            int n=q.size();
            int min=q.peek().index;
            for(int i=0;i<n;i++){
                int current=q.peek().index-min;
                TreeNode c=q.poll().node;
                if(i==0){
                    f=current;
                }
                if(i==n-1){
                    l=current;
                }
                if(c.left!=null){
                    q.add(new Pair(c.left,(2*current)+1));
                }
                if(c.right!=null){
                    q.add(new Pair(c.right,(2*current)+2));
                }
            }
            ans=Math.max(ans,(l-f)+1);
        }
        return ans;
    }
}