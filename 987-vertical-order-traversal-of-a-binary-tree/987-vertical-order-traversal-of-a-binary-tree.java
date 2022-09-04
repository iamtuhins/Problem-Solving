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
            Pair p=q.remove();
            TreeNode temp=p.val;
            int row=p.ver;
            int colm=p.lvle;
            if(!mp.containsKey(row)){
                mp.put(row,new TreeMap<>());
            }
            if(!mp.get(row).containsKey(colm)){
                mp.get(row).put(colm,new PriorityQueue<>());
            }
            mp.get(row).get(colm).add(temp.val);
            if(temp.left!=null){
                q.add(new Pair(row-1,colm+1,temp.left));
            }
            if(temp.right!=null){
                q.add(new Pair(row+1,colm+1,temp.right));
            }
            
        }
        List<List<Integer>>sol=new ArrayList<>();
        for(Map<Integer,PriorityQueue<Integer>>vVal: mp.values()){
            List<Integer>temp=new ArrayList<>();
            for(PriorityQueue<Integer>nodes:vVal.values()){
                while(!nodes.isEmpty()){
                    temp.add(nodes.poll());
                }
            }
            sol.add(new ArrayList<Integer>(temp));
        }
        return sol;
        
    }
}
class Pair{
    int ver;
    int lvle;
    TreeNode val;
    Pair(int n,int m,TreeNode nmd){
        this.ver=n;
        this.lvle=m;
        this.val=nmd;
    }
}