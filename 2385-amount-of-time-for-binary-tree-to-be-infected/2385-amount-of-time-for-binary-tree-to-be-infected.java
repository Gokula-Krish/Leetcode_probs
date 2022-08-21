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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> map=new HashMap();
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        TreeNode infect=null;
        map.put(root,null);
        while(!q.isEmpty()){
            TreeNode c=q.poll();
            if(c.val==start){
                infect=c;
            }
            if(c.left!=null){
                map.put(c.left,c);
                q.add(c.left);
            }
            if(c.right!=null){
                map.put(c.right,c);
                q.add(c.right);
            }
        }
        q.add(infect);
        HashSet<TreeNode> set=new HashSet();
        set.add(infect);
        int count=-1;
        while(!q.isEmpty()){
            int n=q.size();
            count++;
            for(int i=0;i<n;i++){
                TreeNode c=q.poll();
                TreeNode parent=map.get(c);
                if(!set.contains(c.left) && c.left!=null){
                    q.add(c.left);set.add(c.left);
                }
                if(!set.contains(c.right) && c.right!=null){
                    q.add(c.right);set.add(c.right);
                }
                if(parent!=null && !set.contains(parent)){
                    q.add(parent);set.add(parent);
                }
            }
        }
        return count;
    }
}