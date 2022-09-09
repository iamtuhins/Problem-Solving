/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode sol;
        sol=fn(root,p,q);
        return sol;
        
        
    }
    TreeNode fn(TreeNode nd,TreeNode n,TreeNode m){
        if(nd==null){
            return null;
        }
        if(n.val<nd.val && m.val<nd.val){
            return fn(nd.left,n,m);
        }
        if(n.val>nd.val && m.val>nd.val){
            return fn(nd.right,n,m);
        }
        return nd;
    }
}