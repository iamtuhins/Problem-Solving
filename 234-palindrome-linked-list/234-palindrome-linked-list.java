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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode temp=midNode(head);
        ListNode m=revNode(temp.next);
        temp.next=null;
        while(head!=null && m!=null){
            if(head.val!=m.val){
                return false;
            }
            head=head.next;
            m=m.next;
        } 
        return true;
        
    }
    ListNode revNode(ListNode node){
        ListNode prv=null;
        ListNode nt=node;
        while(node!=null){
            nt=node.next;
            node.next=prv;
            prv=node;
            node=nt;
        }
        return prv;
    }
    ListNode midNode(ListNode node){
        ListNode slow=node;
        ListNode fast=node;
        while(fast.next!=null &&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}