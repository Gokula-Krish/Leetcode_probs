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
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head.next==null){
            return head.val==0?null:head;
        }
        HashMap<Integer,ListNode> map=new HashMap();
        ListNode h=head;ListNode last=null;
        int s=0,i=0;
        HashSet<ListNode> set=new HashSet();
        while(h!=null){
            s+=h.val;
            if(s==0){
                deleteNodes(head,h,map,0);
                head=h.next;
            }
            if(map.containsKey(s)){
                ListNode node=map.get(s);
                deleteNodes(node.next,h,map,s);
                node.next=h.next;
            }
            else{
                map.put(s,h);
            }
            h=h.next;
        }
        return head;
    }
    public void deleteNodes(ListNode s,ListNode e,HashMap<Integer,ListNode> map,int sum){
        while(s!=e){
            sum+=s.val;
            map.remove(sum);
            s=s.next;
        }
    }
}