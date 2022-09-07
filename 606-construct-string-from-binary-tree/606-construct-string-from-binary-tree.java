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
    public String tree2str(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        fn(root,sb);
        String sol=sb.toString();
        return sol;
        
    }
    void fn(TreeNode nd,StringBuilder sb){
        if(nd==null){
            return;
        }
        if(nd.left==null && nd.right==null){
            sb.append(nd.val);
            return;
        }
        sb.append(nd.val);
        sb.append('(');
        fn(nd.left,sb);
        sb.append(')');
        if(nd.right!=null){
            sb.append('(');
            fn(nd.right,sb);
            sb.append(')');
        }
    }
}