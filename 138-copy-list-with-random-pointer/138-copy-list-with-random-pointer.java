/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap();
        Node h=head;
        while(h!=null){
            map.put(h,new Node(h.val));
            h=h.next;
        }
        h=head;
        while(h!=null){
            Node node=map.get(h);
            node.next=map.get(h.next);
            node.random=map.get(h.random);
            h=h.next;
        }
        return map.get(head);
    }
}