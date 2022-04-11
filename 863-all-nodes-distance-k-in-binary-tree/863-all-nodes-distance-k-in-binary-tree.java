/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public HashMap<TreeNode,TreeNode> mapParent(TreeNode root){
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        HashMap<TreeNode,TreeNode> map=new HashMap();
        map.put(root,null);
        while(!q.isEmpty()){
            TreeNode c=q.poll();
            if(c.left!=null){
                q.add(c.left);
                map.put(c.left,c);
            }
            if(c.right!=null){
                q.add(c.right);
                map.put(c.right,c);
            }
        }
        return map;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list=new ArrayList();
        if(root==null){
            return list;
        }
        if(k==0){
            list.add(target.val);
            return list;
        }
        HashMap<TreeNode,TreeNode> map=mapParent(root);
        int level=0;
        Queue<TreeNode> q=new LinkedList();
        q.add(target);
        HashSet<TreeNode> set=new HashSet();
        set.add(target);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode c=q.poll();
                TreeNode node=map.get(c);
                if(node!=null && !set.contains(node)){
                    q.add(node);
                    set.add(node);
                }
                if(c.left!=null && !set.contains(c.left)){
                    q.add(c.left);
                    set.add(c.left);
                }
                if(c.right!=null && !set.contains(c.right)){
                    q.add(c.right);
                    set.add(c.right);
                } 
            }
            level++;
            if(level==k){
                for(TreeNode node:q){
                    list.add(node.val);
                }
                return list;
            }
        }
        return list;
    }
}