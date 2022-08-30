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
    public void preOrder(TreeNode root,int row,int col){
        if(root==null){
            return;
        }
        if(map.containsKey(col)){
            if(map.get(col).containsKey(row)){
                map.get(col).get(row).add(root.val);
            }
            else{
                map.get(col).put(row,new PriorityQueue());
                map.get(col).get(row).add(root.val);
            }
        }
        else{
            map.put(col,new TreeMap<Integer,PriorityQueue<Integer>>());
            map.get(col).put(row,new PriorityQueue());
            map.get(col).get(row).add(root.val);
        }
        preOrder(root.left,row+1,col-1);
        preOrder(root.right,row+1,col+1);
    }
    TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ls=new ArrayList();
        preOrder(root,0,0);
        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> e:map.entrySet()){
            List<Integer> l=new ArrayList();
            TreeMap<Integer,PriorityQueue<Integer>> m1=e.getValue();
            for(Map.Entry<Integer,PriorityQueue<Integer>> e1:m1.entrySet()){
                PriorityQueue<Integer> p1=e1.getValue();
                while(!p1.isEmpty()){
                    l.add(p1.poll());
                }
            }
            ls.add(l);
        }
        return ls;
    }
}