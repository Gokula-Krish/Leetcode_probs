/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> st=new Stack();
        ListNode h1=head;int n1=0;
        while(h1!=null){
            st.push(h1);
            h1=h1.next;n1++;
        } 
        int i=0;
        ListNode h=head,prev=null;
        while(h!=null){
            ListNode cur=h;
            if(i==n1-1){
                cur.next=null;
            }ListNode c=h;
            if(i%2!=0 && !st.empty() && st.peek()!=cur){
                c=st.pop();
                prev.next=c;
                c.next=cur;
            }i++;
            prev=h;
            h=c.next;
        }
    }
}