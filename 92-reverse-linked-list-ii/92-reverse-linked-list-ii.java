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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode first=null,second=head;
        int n=0;
        ListNode leftN=null;
        ListNode rightN=null;
        if(left==right){
            return head;
        }
        if(left==1){
            leftN=head;
        }
        else{
            first=head;
            while(n<left-2 && first!=null){
                first=first.next;
                n++;
            }
            leftN=first.next!=null?first.next:first;
        }
        n=0;
        while(n<right-1 && second!=null){
            second=second.next;
            n++;
        }
        rightN=second.next!=null?second.next:null;
        ListNode prev=null;
        ListNode c=leftN;
        int t=right-left;
        while(c!=second && c!=null){
            ListNode next=c.next;
            c.next=prev;
            prev=c;
            c=next;
        }
        c.next=prev;
        if(first!=null){
            first.next=c;
        }
        else{
            head=c;
        }
        leftN.next=rightN;
        return head;
    }
}