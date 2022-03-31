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
class BSTIterator {
    ArrayList<Integer> ls=new ArrayList();
    int n=0,i=0;
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        ls.add(root.val);
        inOrder(root.right);
    }
    public BSTIterator(TreeNode root) {
        inOrder(root);
        n=ls.size();
    }
    
    public int next() {
        return ls.get(i++);
    }
    
    public boolean hasNext() {
        return i<n;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */