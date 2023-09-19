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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(inorder[i],i);
        }
        int []id=new int[1];
        id[0]=0;
        TreeNode sol=fn(preorder,inorder,mp,0,n-1,id);
        return sol;
        
       
        
    }
    TreeNode fn(int preorder[],int []inorder,Map<Integer,
                Integer>mp,int idN,int idM,int []id){
        if(idN>idM || id[0]>=preorder.length){
            return null;
        }
        TreeNode temp=new TreeNode(preorder[id[0]]);
        int positions=mp.get(preorder[id[0]]);
        id[0]++;
        temp.left=fn(preorder,inorder,mp,idN,positions-1,id);
        temp.right=fn(preorder,inorder,mp,positions+1,idM,id);
        return temp;
    }
}