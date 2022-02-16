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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode c=head,prev=null,next=head.next;
        c.next=next.next;
        next.next=c;
        head=next;
        prev=head.next;
        ListNode h=head.next.next;
        while(h!=null && h.next!=null){
            ListNode nextNext=h.next.next;
            c=h;next=h.next;
            c.next=next.next;
            next.next=c;
            prev.next=next;
            prev=c;
            h=nextNext;
        }
        return head;
    }
}