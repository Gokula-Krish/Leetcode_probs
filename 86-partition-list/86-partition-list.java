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
        ListNode headF=new ListNode(-1),headS=new ListNode(-1),h1=headF,h2=headS;
        ListNode h=head;
        while(h!=null){
            if(h.val<x){
                h1.next=h;
                h1=h;
            }
            else{
                h2.next=h;
                h2=h;
            }
            h=h.next;
        }
        h1.next=headS.next;
        h2.next=null;
        return headF.next;
    }
}