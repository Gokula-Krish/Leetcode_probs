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
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> list=new ArrayList();
        if(root==null){
            return list;
        }
        Stack<Node> stack=new Stack();
        stack.push(root);
        while(!stack.empty()){
            Node c=stack.pop();
            list.add(c.val);
            for(int i=c.children.size()-1;i>=0;i--){
                stack.push(c.children.get(i));
            }
        }
        return list;
    }
}