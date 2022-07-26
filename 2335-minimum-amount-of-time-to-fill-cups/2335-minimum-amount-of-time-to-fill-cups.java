class Solution {
    public int fillCups(int[] amount) {
        int n=amount.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(amount[0]);
        pq.add(amount[1]);
        int sol=0;
        pq.add(amount[2]);
        while(pq.peek()!=0){
            int num1=pq.poll();
            int num2=pq.poll();
            sol++;
            pq.add(num1-1);
            pq.add(num2-1);
        }
        return sol;
        
        
    }
}