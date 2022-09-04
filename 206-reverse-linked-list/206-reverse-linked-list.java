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
    public ListNode reverseList(ListNode head) {
        return fn(head);
    }
    ListNode fn(ListNode nd){
        ListNode prv=null;
        ListNode next=nd;
        while(nd!=null){
            next=nd.next;
            nd.next=prv;
            prv=nd;
            nd=next;
        }
        return prv;
    }
}