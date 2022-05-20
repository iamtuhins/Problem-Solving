class MedianFinder {
    PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer>minHeap=new PriorityQueue<>();
    boolean even=true;

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }else{
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        even=!even;
    }
    
    public double findMedian() {
        if(even){
            return (maxHeap.peek()+minHeap.peek())/2.00;
        }
        return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */