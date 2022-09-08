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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>sol=new ArrayList<>();
        fn(root,sol);
        return sol;
        
    }
    void fn(TreeNode nd,List<Integer>sol){
        if(nd==null){
            return;
        }
        fn(nd.left,sol);
        sol.add(nd.val);
        fn(nd.right,sol);
    }
}