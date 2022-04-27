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
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(ListNode nd:lists){
            if(nd!=null){
            Pair p=new Pair(nd.val,nd);
            pq.add(p);
            }
        }
        ListNode nd=new ListNode(0);
        ListNode sol=nd;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            nd.next=p.node;
            nd=nd.next;
            if(nd.next!=null){
                Pair temp=new Pair(nd.next.val,nd.next);
                pq.add(temp);
            }
        }
        return sol.next;
        
    }
}
class Pair implements Comparable<Pair>{
    int val;
    ListNode node;
    Pair(int val,ListNode node){
        this.val=val;
        this.node=node;
    }
    public int compareTo(Pair ob){
        return this.val-ob.val;
    }
}