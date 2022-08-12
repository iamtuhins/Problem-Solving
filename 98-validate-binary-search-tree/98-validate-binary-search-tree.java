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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return fn(root,Long.MAX_VALUE,Long.MIN_VALUE);
        
        
    }
    boolean fn(TreeNode nd,long max,long min){
        if(nd==null)
            return true;
        if(nd.val>=max || nd.val<=min)
            return false;
        return fn(nd.left,nd.val,min) && fn(nd.right,max,nd.val);
    }
}