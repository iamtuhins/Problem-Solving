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
        Map<Node,Node>map=new HashMap<>();
        Node sol=fn(map,node);
        return sol;
        
    }
    Node fn(Map<Node,Node>map,Node node){
        if(node==null){
            Node nd=node;
            return nd;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node nd=new Node(node.val);
        map.put(node,nd);
        for(Node tm: node.neighbors){
            nd.neighbors.add(fn(map,tm));
        }
        return nd;
    }
}