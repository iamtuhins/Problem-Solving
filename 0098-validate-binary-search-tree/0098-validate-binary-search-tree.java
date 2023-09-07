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
        long mz=Long.MAX_VALUE;
        long min=Long.MIN_VALUE;
        boolean nm=fn(root,mz,min);
        return nm;
    }
    boolean fn(TreeNode nd,long mz,long min){
        if(nd==null){
            return true;
        }
        if(nd.val>min && mz>nd.val){
            boolean lft=fn(nd.left,nd.val,min);
            boolean rght=fn(nd.right,mz,nd.val);
            if(lft==true && rght==true){
                return true;
            }
        }
        return false;
    }
}