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
    public TreeNode pruneTree(TreeNode root) {
        if(root.left==null && root.right==null && root.val==0){
            return null;
        }
        boolean temp=fn(root);
        if(temp==true)
            return null;
        return root;
        
    }
    boolean fn(TreeNode nd){
        if(nd==null){
            return true;
        }
        boolean lf=false;
        boolean rt=false;
        lf=fn(nd.left);
        rt=fn(nd.right);
        if(lf==true){
            nd.left=null;
        }
        if(rt==true){
            nd.right=null;
        }
        if(lf==true && rt==true && nd.val==0){
            return true;
        }
        return false;
        
    }
}