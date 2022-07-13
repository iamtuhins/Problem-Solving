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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>sol=new ArrayList<>();
        if(root==null){
            return sol;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer>temp=new ArrayList<>();
            int n=q.size();
            double avg=0;
            for(int i=0;i<n;i++){
                TreeNode nd=q.remove();
                if(nd.left!=null){
                    q.add(nd.left);
                }
                if(nd.right!=null){
                    q.add(nd.right);
                }
                temp.add(nd.val);
            }
            int sz=temp.size();
            double num=0;
            for(int j=0;j<sz;j++){
                num=num+temp.get(j);
            }
            avg=num/sz;
            sol.add(avg);
        }
        return sol;
        
    }
}