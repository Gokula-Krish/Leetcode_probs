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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1000);
        ListNode t=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                t.next=l1;
                l1=l1.next;
            }
            else{
                t.next=l2;
                l2=l2.next;
            }t=t.next;
        }
        while(l1!=null){
            t.next=l1;
            l1=l1.next;
            t=t.next;
        }
        while(l2!=null){
            t.next=l2;
            l2=l2.next;
            t=t.next;
        }
        return dummy.next;
    }
}