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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode start = new ListNode();
        // dummy's next start from head
        start.next = head;
        // create two variable slow & fast
        ListNode slow = start;
        ListNode fast = start;
            
        // find nth index
        for(int i=1; i<=n; i++) {
            fast = fast.next;
        }
            
        // while, fast next is not null than
        // slow & fast is increment by 1 step
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
            
        // slow next element points to slow next next
        slow.next = slow.next.next;
            
        // return start next
        return start.next;
    }
    
}
