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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        if(n==0)
            return null;
        TreeNode sol=fn(nums,0,n-1);
        return sol;
        
    }
    TreeNode fn(int nums[],int lf,int ryt){
        if(lf>ryt){
            return null;
        }
        int minNode=(lf+ryt)/2;
        TreeNode nd=new TreeNode(nums[minNode]);
        nd.left=fn(nums,lf,minNode-1);
        nd.right=fn(nums,minNode+1,ryt);
        return nd;
    }
}