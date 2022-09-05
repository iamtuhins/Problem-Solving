/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode temp=head;
        Map<ListNode,Integer>map=new HashMap<>();
        int id=0;
        while(temp!=null){
            if(map.containsKey(temp)){
                return temp;
            }
            map.put(temp,id);
            id++;
            temp=temp.next;
        }
        return null;
    }
}