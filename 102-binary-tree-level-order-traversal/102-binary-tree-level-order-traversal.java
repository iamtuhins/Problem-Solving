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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>sol=new ArrayList<>();
        if(root==null){
            return sol;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer>temp=new ArrayList<>();
            int m=q.size();
            for(int i=0;i<m;i++){
                TreeNode nd=q.remove();
                if(nd.left!=null){
                    q.add(nd.left);
                }
                if(nd.right!=null){
                    q.add(nd.right);
                }
                temp.add(nd.val);
            }
            sol.add(temp);
        }
        return sol;
        
    }
}