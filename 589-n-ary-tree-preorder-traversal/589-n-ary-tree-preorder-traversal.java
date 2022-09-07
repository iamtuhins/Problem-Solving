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
    public List<Integer> preorder(Node root) {
        List<Integer>sol=new ArrayList<>();
        if(root==null){
            return sol;
        }
        fn(root,sol);
        return sol;
        
    }
    void fn(Node nd,List<Integer>ls){
        ls.add(nd.val);
        for(Node temp: nd.children){
            fn(temp,ls);
        }
    }
}