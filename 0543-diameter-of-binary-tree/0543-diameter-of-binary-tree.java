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
    public int diameterOfBinaryTree(TreeNode root) {
        int sol[]=new int[1];
        fn(root,sol);
        return sol[0];
        
    }
    int fn(TreeNode nd,int []sol){
        if(nd==null){
            return 0;
        }
        int lft=fn(nd.left,sol);
        int ryt=fn(nd.right,sol);
        sol[0]=Math.max(sol[0],lft+ryt);
        int val=Math.max(lft,ryt);
        return val+1;
    }
}