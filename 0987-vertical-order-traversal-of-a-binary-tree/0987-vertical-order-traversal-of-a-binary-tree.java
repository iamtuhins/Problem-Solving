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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,Map<Integer,PriorityQueue<Integer>>>mp=new TreeMap<>();
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(0,0,root));
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int colm=temp.lvl;
            int row=temp.row;
            TreeNode node=temp.node;
            
            if(!mp.containsKey(colm)){
                mp.put(colm,new TreeMap<>());
            }
            if(!mp.get(colm).containsKey(row)){
                mp.get(colm).put(row,new PriorityQueue<>());
            }
            mp.get(colm).get(row).add(node.val);
            
            if(node.left!=null){
                q.add(new Pair(colm-1,row+1,node.left));
            }
            if(node.right!=null){
                q.add(new Pair(colm+1,row+1,node.right));
            }
        }
        List<List<Integer>>sol=new ArrayList<>();
        for(Map<Integer,PriorityQueue<Integer>> lvlMap: mp.values()){
            List<Integer>temp=new ArrayList<>();
            for(PriorityQueue<Integer>pq: lvlMap.values()){
                while(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            sol.add(new ArrayList<Integer>(temp));
        }
        return sol;
        
    }
}
class Pair{
    int lvl=0;
    int row=0;
    TreeNode node;
    Pair(int l,int r,TreeNode n){
        this.lvl=l;
        this.row=r;
        this.node=n;
    }
}