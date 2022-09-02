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
        Queue<TreeNode>q=new LinkedList<>();
        List<Double>sol=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int nm=q.size();
            Double nums=0.00;
            for(int i=0;i<nm;i++){
                TreeNode temp=q.remove();
                nums+=temp.val;
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            double avg=nums/nm;
            sol.add(avg);
        }
        return sol;
        
        
    }
}