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
        TreeNode m=fn(root,p,q);
        return m;
        
    }
    TreeNode fn(TreeNode nd, TreeNode p, TreeNode q){
        if(nd==null || nd==p || nd==q){
            return nd;
        }
        TreeNode left=fn(nd.left,p,q);
        TreeNode rgt=fn(nd.right,p,q);
        
        if(left==null){
            return rgt;
        }else if(rgt==null){
            return left;
        }
        return nd;
    }
}