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
    ListNode sorted;
    public ListNode insertionSortList(ListNode head) {
        sorted=null;
        ListNode c=head;
        while(c!=null){
            ListNode next=c.next;
            sortIt(c);
            c=next;
        }
        head=sorted;
        return head;
    }
    public void sortIt(ListNode n){
        if(sorted==null || sorted.val>=n.val){
            n.next=sorted;
            sorted=n;
        }
        else{
            ListNode c=sorted,prev=null;
            while(c!=null && c.val<n.val){
                prev=c;
                c=c.next;   
            }
            prev.next=n;
            n.next=c;
        }
    }
}