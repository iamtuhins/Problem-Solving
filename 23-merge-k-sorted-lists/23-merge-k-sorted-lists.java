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
        int n=lists.length;
        if(n<1){
            return null;
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            ListNode temp=lists[i];
            if(temp!=null){
            Pair p=new Pair(temp,temp.val);
            pq.add(p);
            }
        }
        ListNode nd=new ListNode();
        ListNode sol=nd;
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            nd.next=p.node;
            nd=nd.next;
            if(nd.next!=null){
                Pair temp=new Pair(nd.next,nd.next.val);
                pq.add(temp);
            }
            
        }
        return sol.next;
        
    }
}
class Pair implements Comparable<Pair>{
    ListNode node;
    int val;
    Pair(ListNode node,int val){
        this.node=node;
        this.val=val;
    }
    public int compareTo(Pair ob){
        return this.val-ob.val;
    }
}