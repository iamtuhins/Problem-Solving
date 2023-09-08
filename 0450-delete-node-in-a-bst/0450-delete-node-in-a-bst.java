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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode nd=findNode(root,key);
        return nd;
    }
    TreeNode findNode(TreeNode root, int key){
        if(root==null){
            return null;
        }
        if(root.val==key){
            TreeNode temp=replace(root);
            return temp;
        }
        
        
        if(root.val>key){
            root.left=findNode(root.left,key);
        }else{
            root.right=findNode(root.right,key);
        }
        return root;
    }
    TreeNode replace(TreeNode val){
        if(val.left==null && val.right==null){
            return null;
        }
        if(val.left==null){
            return val.right;
        }else if(val.right==null){
            return val.left;
        }
        TreeNode rightChild=val.right;
        TreeNode fullRight=findRight(val.left);
        fullRight.right=rightChild;
        return val.left;
    }
    
    TreeNode findRight(TreeNode nd){
        if(nd.right==null){
            return nd;
        }
        return findRight(nd.right);
    }
}
