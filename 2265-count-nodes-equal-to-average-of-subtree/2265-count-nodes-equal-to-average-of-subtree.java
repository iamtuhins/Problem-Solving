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
    public int averageOfSubtree(TreeNode root) {
        if(root.left==null && root.right==null){
            return 1;
        }
        int sol[]=new int[1];
        ag(root,sol);
        return sol[0];
        
        
        
        
    }
    void ag(TreeNode node,int sol[]){
        if(node==null){
            return;
        }
        int sz=size(node);
        int sm=sum(node);
        ag(node.left,sol);
        ag(node.right,sol);
        int temp=sm/sz;
        if(temp==node.val){
            sol[0]++;
        }
        
    }
    int sum(TreeNode node){
        if(node==null){
            return 0;
        }
        int lf=sum(node.left);
        int rt=sum(node.right);
        return node.val+(lf+rt);
        
    }
    int size(TreeNode node){
        if(node==null){
            return 0;
        }
        int lf=size(node.left);
        int rt=size(node.right);
        return 1+(lf+rt);
        
    }
}