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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode t=head;int n=0;
        if(head==null){
            return head;
        }
        while(t.next!=null){
            t=t.next;
            n++;
        }n++;
        if(k%n==0){
            return head;
        }
        if(k>n){
            k=k%n;
        }ListNode x=head;
        for(int i=0;i<n-k-1;i++){
            x=x.next;
        }
        ListNode y=x.next;
        x.next=null;
        t.next=head;
        head=y;
        return head;
    }
}