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
            return null;
        }
        Map<Node,Node>mp=new HashMap<>();
        Node sol=fn(node,mp);
        return sol;
        
    }
    Node fn(Node node,Map<Node,Node>mp){
        if(node==null){
            return null;
        }
        if(mp.containsKey(node)){
            return mp.get(node);
        }
        Node nn=new Node(node.val);
        mp.put(node,nn);
        for(Node temp: node.neighbors){
            nn.neighbors.add(fn(temp,mp));
        }
        return nn;
    }
}