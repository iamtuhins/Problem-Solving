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
        TreeNode n=fn(root,p,q);
        return n;
        
    }
    TreeNode fn(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left=fn(root.left,p,q);
        TreeNode ryt=fn(root.right,p,q);
        
        if(left==null){
            return ryt;
        }else if(ryt==null){
            return left;
        }
        return root;
    }
    
}