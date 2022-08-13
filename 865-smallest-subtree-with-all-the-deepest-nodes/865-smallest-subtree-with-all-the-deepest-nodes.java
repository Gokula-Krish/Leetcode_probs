// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     TreeNode res=null;
//     public int postOrder(TreeNode root){
//         if(root==null){
//             return 0;
//         }
//         int l=postOrder(root.left);
//         int r=postOrder(root.right);
//         if(l==r){
//             System.out.println(l+"----"+r+" and root is "+root.val);
//             res=root;
//         }
//         return 1+Math.max(l,r);
//     }
//     public TreeNode subtreeWithAllDeepest(TreeNode root) {
//         int re=postOrder(root);
//         System.out.println(re);
//         return res;
//         // Queue<TreeNode> q=new LinkedList();
//         // q.add(root);
//         // HashMap<TreeNode,TreeNode> map=new HashMap();
//         // LinkedList<TreeNode> list=new LinkedList();
//         // while(!q.isEmpty()){
//         //     int n=q.size();
//         //     list.clear();
//         //     for(int i=0;i<n;i++){
//         //         TreeNode c=q.poll();
//         //         list.add(c);
//         //         if(c.left!=null){
//         //             q.add(c.left);
//         //             map.put(c.left,c);
//         //         }
//         //         if(c.right!=null){
//         //             q.add(c.right);
//         //             map.put(c.right,c);
//         //         }
//         //     }
//         // }
//         // if(list.size()==1){
//         //     return list.get(0);
//         // }
//         // int j=0;
//         // HashSet<TreeNode> set=new HashSet();
//         // while(set.size()!=1){
//         //     set.clear();
//         //     for(int i=0;i<list.size();i++){
//         //         TreeNode node=map.get(list.get(i));
//         //         set.add(node);
//         //     }
//         //     list.clear();
//         //     list.addAll(set);
//         // }
//         // return set.iterator().next();
//     }
// }
// class Solution {
//     Map<TreeNode, Integer> depth;
//     int max_depth;
//     public TreeNode subtreeWithAllDeepest(TreeNode root) {
//         depth = new HashMap();
//         depth.put(null, -1);
//         dfs(root, null);
//         max_depth = -1;
//         for (Integer d: depth.values())
//             max_depth = Math.max(max_depth, d);

//         return answer(root);
//     }

//     public void dfs(TreeNode node, TreeNode parent) {
//         if (node != null) {
//             depth.put(node, depth.get(parent) + 1);
//             dfs(node.left, node);
//             dfs(node.right, node);
//         }
//     }

//     public TreeNode answer(TreeNode node) {
//         if (node == null || depth.get(node) == max_depth)
//             return node;
//         TreeNode L = answer(node.left),
//                  R = answer(node.right);
//         if (L != null && R != null) return node;
//         if (L != null) return L;
//         if (R != null) return R;
//         return null;
//     }
// }
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);
        Result L = dfs(node.left),
               R = dfs(node.right);
        if (L.dist > R.dist) return new Result(L.node, L.dist + 1);
        if (L.dist < R.dist) return new Result(R.node, R.dist + 1);
        return new Result(node, L.dist + 1);
    }
}

/**
 * The result of a subtree is:
 *       Result.node: the largest depth node that is equal to or
 *                    an ancestor of all the deepest nodes of this subtree.
 *       Result.dist: the number of nodes in the path from the root
 *                    of this subtree, to the deepest node in this subtree.
 */
class Result {
    TreeNode node;
    int dist;
    Result(TreeNode n, int d) {
        node = n;
        dist = d;
    }
}