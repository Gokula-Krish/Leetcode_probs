/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        Queue<Node> q=new LinkedList();
        int l=0;
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                Node c=q.poll();
                for(Node node:c.children){
                    q.add(node);
                }
            }l++;
        }
        return l;
    }
}