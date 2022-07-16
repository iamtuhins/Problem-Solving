/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        Map<Node,Node>map=new HashMap<>();
        Node sol=fn(map,node);
        return sol;
    }
    Node fn(Map<Node,Node>mp,Node node){
        if(mp.containsKey(node)){
            return mp.get(node);
        }
        if(node==null){
            Node nm=node;
            return nm;
        }
        Node temp=new Node(node.val);
        mp.put(node,temp);
        for(Node n: node.neighbors){
            temp.neighbors.add(fn(mp,n));
            
        }
        return temp;
    }
}