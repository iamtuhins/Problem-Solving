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
    public int maxPathSum(TreeNode root) {
        int sums[]=new int[1];
        sums[0]=Integer.MIN_VALUE;
        fn(root,sums);
        return sums[0];
    }
    int fn(TreeNode root,int sums[]){
        if(root==null){
            return 0;
        }
        int lft=Math.max(0,fn(root.left,sums));
        int ryt=Math.max(0,fn(root.right,sums));
        sums[0]=Math.max(sums[0],lft+ryt+root.val);
        int val=root.val+Math.max(lft,ryt);
        return val;
    }
}