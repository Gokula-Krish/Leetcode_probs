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
    int max=0;
    public int preOrder(TreeNode root,int level){
        if(root==null){
            return 0;
        }
        int left=preOrder(root.left,level+1);
        int right=preOrder(root.right,level+1);
        if(left==right && left+level>=max){
            res=root;
            max=left+level;
        }
        return 1+Math.max(left,right);
    }
    HashMap<TreeNode,TreeNode>  map=new HashMap();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        preOrder(root,0);
        return res;
       // System.out.println(re);
       // return map.get(res);
        // Queue<TreeNode> q=new LinkedList();
        // q.add(root);
        // map=new HashMap();
        // LinkedList<TreeNode> list=new LinkedList();
        // while(!q.isEmpty()){
        //     int n=q.size();
        //     list.clear();
        //     for(int i=0;i<n;i++){
        //         TreeNode c=q.poll();
        //         list.add(c);
        //         if(c.left!=null){
        //             q.add(c.left);
        //             map.put(c.left,c);
        //         }
        //         if(c.right!=null){
        //             q.add(c.right);
        //             map.put(c.right,c);
        //         }
        //     }
        // }
        // if(list.size()==1){
        //     return list.get(0);
        // }
        // int j=0;
        // HashSet<TreeNode> set=new HashSet();
        // while(set.size()!=1){
        //     set.clear();
        //     for(int i=0;i<list.size();i++){
        //         TreeNode node=map.get(list.get(i));
        //         set.add(node);
        //     }
        //     list.clear();
        //     list.addAll(set);
        // }
        // return set.iterator().next();
    }
}
