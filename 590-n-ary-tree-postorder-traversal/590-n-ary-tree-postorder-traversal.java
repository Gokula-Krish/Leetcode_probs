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
    public List<Integer> postorder(Node root) {
        if(root==null){
            return new ArrayList();
        }
        ArrayList<Integer> list=new ArrayList();
        Stack<Node> stack1=new Stack();
        Stack<Node> stack2=new Stack();
        stack1.push(root);
        while(!stack1.empty()){
            Node c=stack1.pop();
            stack2.push(c);
            for(Node node:c.children){
                stack1.push(node);
            }
        }
        while(!stack2.empty()){
            Node c=stack2.pop();
            list.add(c.val);
        }
        return list;
    }
}