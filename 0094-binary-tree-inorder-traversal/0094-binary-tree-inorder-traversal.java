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
        List<Integer>ls=new ArrayList<>();
        fn(root,ls);
        return ls;
        
    }
    void fn(TreeNode nd,List<Integer>ls){
        if(nd==null){
            return;
        }
        fn(nd.left,ls);
        ls.add(nd.val);
        fn(nd.right,ls);
    }
}