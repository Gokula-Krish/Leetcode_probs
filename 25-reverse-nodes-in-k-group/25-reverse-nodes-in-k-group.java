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
    public ListNode reverseKGroup(ListNode head, int k) {
        int n=0;
        ListNode h=head;
        while(h!=null){
            n++;h=h.next; 
        }
        ListNode t=head;
        int j=0;
        ListNode prev=null,lastPrev=null;
        while(t!=null){
            ListNode x=t,c=t,next=null;
            int i=0;
            int d=Math.abs(n-j);
            boolean ans=false;
            if(d<k){
                break;
            }
            prev=null;
            while(c!=null && i<k && d>=k){
                next=c.next;
                c.next=prev;
                prev=c;
                c=next;i++;
                ans=true;
            }
            if(j==0){
                head=prev;
            }
            if(ans){
                x.next=next;
            }
            if(lastPrev!=null){
                lastPrev.next=prev;
            }
            lastPrev=x;
            t=t.next;j+=k;
        }
        return head;
    }
}