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
        if(root.left==null && root.right==null){
            return true;
        }
        boolean sol;
        long mz=Long.MAX_VALUE;
        long min=Long.MIN_VALUE;
        sol=fn(root,mz,min);
        return sol;
        
    }
    boolean fn(TreeNode nd,long mz,long min){
        if(nd==null){
            return true;
        }
        if(nd.val<=min || nd.val>=mz){
            return false;
        }
        return (fn(nd.left,nd.val,min) && fn(nd.right,mz,nd.val));
    }
}