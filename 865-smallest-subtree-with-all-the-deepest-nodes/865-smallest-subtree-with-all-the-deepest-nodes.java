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
    TreeNode res=null;
    public int postOrder(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=postOrder(root.left);
        int r=postOrder(root.right);
        if(l==r){
            System.out.println(l+"----"+r+" and root is "+root.val);
            res=root;
        }
        return 1+Math.max(l,r);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // int re=postOrder(root);
        // System.out.println(re);
        // return res;
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        HashMap<TreeNode,TreeNode> map=new HashMap();
        LinkedList<TreeNode> list=new LinkedList();
        while(!q.isEmpty()){
            int n=q.size();
            list.clear();
            for(int i=0;i<n;i++){
                TreeNode c=q.poll();
                list.add(c);
                if(c.left!=null){
                    q.add(c.left);
                    map.put(c.left,c);
                }
                if(c.right!=null){
                    q.add(c.right);
                    map.put(c.right,c);
                }
            }
        }
        if(list.size()==1){
            return list.get(0);
        }
        int j=0;
        HashSet<TreeNode> set=new HashSet();
        while(set.size()!=1){
            set.clear();
            for(int i=0;i<list.size();i++){
                TreeNode node=map.get(list.get(i));
                set.add(node);
            }
            list.clear();
            list.addAll(set);
        }
        return set.iterator().next();
    }
}
