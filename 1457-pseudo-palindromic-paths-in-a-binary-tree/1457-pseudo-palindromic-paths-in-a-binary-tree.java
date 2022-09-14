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
    public int pseudoPalindromicPaths (TreeNode root) {
        int sol[]=new int[1];
        int arr[]=new int[10];
        fn(root,arr,sol);
        return sol[0];
        
    }
    void fn(TreeNode nd,int []nums,int sol[]){
        if(nd==null)
            return;
        nums[nd.val]++;
        if(nd.left==null && nd.right==null){
            int temp=0;
            for(int i=1;i<=9;i++){
                if(nums[i]%2!=0){
                    temp++;
                }
                if(temp>1){
                    break;
                }
            }
            if(1>=temp){
                sol[0]++;
            }
        }
        fn(nd.left,nums,sol);
        fn(nd.right,nums,sol);
        nums[nd.val]--;
    }
}