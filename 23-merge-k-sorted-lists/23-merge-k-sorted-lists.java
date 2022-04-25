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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length<=0){
            return null;
        }
        ListNode nd=new ListNode();
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(ListNode ls: lists){
            if(ls!=null){
            Pair p=new Pair(ls.val,ls);
            pq.add(p);
            }
        }
        ListNode sol=nd;
        while(!pq.isEmpty()){
            Pair ppt=pq.poll();
            nd.next=ppt.list;
            nd=nd.next;
            if(nd.next!=null){
                Pair p=new Pair(nd.next.val,nd.next);
                pq.add(p);
            }
        }
        return sol.next;
        
        
    }
}
class Pair implements Comparable<Pair>{
    int val;
    ListNode list;
    Pair(int val,ListNode list){
        this.val=val;
        this.list=list;
    }
    public int compareTo(Pair obj){
        return this.val-obj.val;
    }
    
}