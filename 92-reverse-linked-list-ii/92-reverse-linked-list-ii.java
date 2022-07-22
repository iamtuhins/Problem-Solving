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
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prv=dummy;
        for(int i=1;i<left;i++){
            prv=prv.next;
        }
        ListNode cun=prv.next;
        for(int i=0;i<right-left;i++){
            ListNode fwd=cun.next;
            cun.next=fwd.next;
            fwd.next=prv.next;
            prv.next=fwd;
        }
        return dummy.next;
        
    }
}