/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    ArrayList<Integer> ls=new ArrayList();
    public Node flatten(Node head) {
        recursion(head);
        Node dummy=new Node(-11111);
        Node temp=dummy;
        Node prev=null;
        for(int a:ls){
            temp.next=new Node(a);
            temp.next.prev=prev;
            temp=temp.next;
            prev=temp;
        }
        return dummy.next;
    }
    public void recursion(Node node){
        if(node==null){
            return;
        }
        ls.add(node.val);
        recursion(node.child);
        recursion(node.next);
    }
}