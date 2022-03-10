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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1=l1,h2=l2;
        ListNode dummy=new ListNode(-111111);
        ListNode temp=dummy;
        int c=0;
        while(h1!=null || h2!=null){
            int s=(h1==null?0:h1.val)+(h2==null?0:h2.val)+c;
            int s1=s%10;
            c=s/10;
            temp.next=new ListNode(s1);
            temp=temp.next;
            if(h1!=null){
                h1=h1.next;
            }
            if(h2!=null){
                h2=h2.next;
            }
        }
        if(c!=0){
            temp.next=new ListNode(c);
        }
        return dummy.next;
    }
}