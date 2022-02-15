/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "N";
        }
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       // System.out.println(data);
        String[] sp=data.split(",");
        Queue<String> q=new LinkedList();
        q.addAll(Arrays.asList(sp));
        return buildTree(q,null);
    }
    public TreeNode buildTree(Queue<String> q,TreeNode root){
        if(!q.isEmpty()){
            String str=q.poll();
            if(!str.equals("N")){
                root=new TreeNode(Integer.parseInt(str));
                root.left=buildTree(q,root.left);
                root.right=buildTree(q,root.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));