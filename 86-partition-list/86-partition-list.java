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
    public ListNode partition(ListNode head, int x) {
        ListNode head1=new ListNode(-1111),head2=new ListNode(-1111),headF=null,headS=null;
        ListNode h=head;
        while(h!=null){
            if(h.val<x){
                if(headF==null){
                    headF=h;
                }
                head1.next=h;
                head1=head1.next;
            }
            else if(h.val>=x){
                if(headS==null){
                    headS=h;
                }
                head2.next=h;
                head2=head2.next;
            }
            h=h.next;
        }
        head1.next=headS;
        head2.next=null;
        return headF==null?headS:headF;
    }
}