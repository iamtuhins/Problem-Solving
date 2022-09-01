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
    public int goodNodes(TreeNode root) {
        int nums[]=new int[1];
        fn(root,nums,Integer.MIN_VALUE);
        return nums[0];
        
        
    }
    void fn(TreeNode nd,int nums[],int largest){
        if(nd==null){
            return;
        }
        if(largest<=nd.val){
            largest=nd.val;
            nums[0]++;
        }
        fn(nd.left,nums,largest);
        fn(nd.right,nums,largest);
    }
}