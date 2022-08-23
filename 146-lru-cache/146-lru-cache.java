class LRUCache { 
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    Map<Integer,Node>mp=new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prv=head;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            Node temp=mp.get(key);
            delete(temp);
            insert(temp);
            mp.put(key,temp);
            return temp.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            delete(mp.get(key));
        }
        if(mp.size()==capacity){
            delete(tail.prv);
        }
        Node nd=new Node(key,value);
        insert(nd);
        
    }
    void delete(Node node){
        mp.remove(node.key);
        node.prv.next=node.next;
        node.next.prv=node.prv;
    }
    void insert(Node node){
        mp.put(node.key,node);
        node.next=head.next;
        head.next=node;
        node.prv=head;
        node.next.prv=node;
    }
}
class Node{
    Node prv;
    Node next;
    int key;
    int value;
    Node(int k,int v){
        this.key=k;
        this.value=v;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */