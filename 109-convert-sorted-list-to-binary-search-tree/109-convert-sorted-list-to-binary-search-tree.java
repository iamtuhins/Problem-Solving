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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer>ls=new ArrayList<>();
        allList(head,ls);
        int n=ls.size();
        if(n==0) return null;
        TreeNode sol=fn(ls,0,n-1);
        return sol;
    }
    void allList(ListNode nd,List<Integer>ls){
        while(nd!=null){
            ls.add(nd.val);
            nd=nd.next;
        }
    }
    TreeNode fn(List<Integer>ls,int lf,int rt){
        if(lf>rt){
            return null;
        }
        int midNode=(lf+rt)/2;
        TreeNode nd=new TreeNode(ls.get(midNode));
        nd.left=fn(ls,lf,midNode-1);
        nd.right=fn(ls,midNode+1,rt);
        return nd;
    }
}