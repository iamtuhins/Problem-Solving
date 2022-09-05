/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null){
            List<List<Integer>>temp=new ArrayList<>();
            return temp;
        }
        List<List<Integer>>sol=new ArrayList<>();
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz=q.size();
            List<Integer>ls=new ArrayList<>();
            for(int i=0;i<sz;i++){
                Node temp=q.remove();
                ls.add(temp.val);
                q.addAll(temp.children);
            }
            sol.add(new ArrayList<>(ls));
        }
        return sol;
        
    }
}