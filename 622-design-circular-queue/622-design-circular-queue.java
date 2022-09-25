class MyCircularQueue {
    int sz=0;
    List<Integer>ls;
    public MyCircularQueue(int k) {
        this.sz=k;
        ls=new ArrayList<>();
    }
    
    public boolean enQueue(int value) {
        if(ls.size()>=sz){
            return false;
        }
        return ls.add(value);
    }
    
    public boolean deQueue() {
        if(ls.size()==0){
            return false;
        }
        ls.remove(0);
        return true;
    }
    
    public int Front() {
        int temp=ls.size();
        if(temp==0){
            return -1;
        }
        return ls.get(0);
    }
    
    public int Rear() {
        int temp=ls.size();
        if(temp==0){
            return -1;
        }
       int num=ls.get(temp-1);
        return num;
    }
    
    public boolean isEmpty() {
        if(ls.size()==0){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(ls.size()==sz){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */