class MedianFinder {
    //to store all the large number and find the smallest among them
    PriorityQueue<Integer>minHeap=new PriorityQueue<>();
    //to store all the small number and find the largest among them
    PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    boolean even=true;

    public MedianFinder() {
        even=true;
    }
    
    public void addNum(int num) {
        //if even and now we need to add one more number then it will be odd 
        //so i'll add it in maxheap first and than poll out largest amog them and will store it in minHeap.
        if(even){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }else{
            //else i'll add it in the minHeap first and then will poll out and store it in the maxHeap
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        //will making opposite what it is
        even=!even;
    }
    
    public double findMedian() {
        if(even){
            //if it is even 
            return (minHeap.peek()+maxHeap.peek())/2.00;
        }
        //if it's odd 
        return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */