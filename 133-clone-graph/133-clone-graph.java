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
        Node sol=dfs(map,node);
        return sol;
        
    }
    Node dfs(Map<Node,Node>map,Node node){
        if(map.containsKey(node)){
            return map.get(node);
        }
        if(node==null){
            Node m=node;
            return m;
        }
        Node temp=new Node(node.val);
        map.put(node,temp);
        for(Node n:node.neighbors){
            temp.neighbors.add(dfs(map,n));
        }
        return temp;
    }
}