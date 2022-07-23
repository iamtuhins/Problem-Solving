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
        ListNode temp=new ListNode(0);
        int sm=0;
        ListNode sol=temp;
        while(head.next!=null){
            sm=sm+head.val;
            if(head.next.val==0){
                temp.next=new ListNode(sm);
                temp=temp.next;
                sm=0;
            }
            head=head.next;
        }
        return sol.next;
    }
}