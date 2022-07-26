class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int sol=0;
        while(pq.peek()!=0){
            int num1=pq.poll();
            int num2=pq.poll();
            if(num1==0 || num2==0){
                break;
            }
            sol++;
            pq.add(num1-1);
            pq.add(num2-1);
        }
        return sol;
        
    }
}