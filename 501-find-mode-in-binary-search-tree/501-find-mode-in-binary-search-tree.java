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
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer>map=new HashMap<>();
        fn(root,map);
        int mn=Integer.MIN_VALUE;
        for(HashMap.Entry<Integer,Integer>en: map.entrySet()){
            if(en.getValue()>mn){
                mn=en.getValue();
            }
        }
        List<Integer>ls=new ArrayList<>();
        for(HashMap.Entry<Integer,Integer>en: map.entrySet()){
            if(en.getValue()==mn){
                ls.add(en.getKey());
            }
        }
        int n=ls.size();
        int sol[]=new int[n];
        for(int i=0;i<n;i++){
            sol[i]=ls.get(i);
        }
         return sol;
        
    }
    void fn(TreeNode nd,Map<Integer,Integer>map){
        if(nd==null)
            return;
        map.put(nd.val,map.getOrDefault(nd.val,0)+1);
        fn(nd.left,map);
        fn(nd.right,map);
    }
}