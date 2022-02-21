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
    public ListNode mergeNodes(ListNode head) {
        ArrayList<Integer> ls=new ArrayList();
        ListNode h=head;
        while(h!=null){
            if(h.val==0){
                if(h.next!=null){
                    int sum=getSum(h.next);
                    ls.add(sum);
                }
            }
            h=h.next;
        }
        ListNode dummy=new ListNode(-1111);
        ListNode temp=dummy;
        for(int i:ls){
            temp.next=new ListNode(i);
            temp=temp.next;
        }
        return dummy.next;
    }
    public int getSum(ListNode h){
        int s=0;
        while(h!=null && h.val!=0){
            s+=h.val;
            h=h.next;
        }
        return s;
    }
}