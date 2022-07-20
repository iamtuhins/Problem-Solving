class Solution {
    public int fillCups(int[] amount) {
        int sol=0;
        int n=amount.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(amount[0]);
        pq.add(amount[1]);
        pq.add(amount[2]);
        while(pq.peek()!=0){
            int j=pq.poll();
            int k=pq.poll();
            sol++;
            pq.add(j-1);
            pq.add(k-1);
            
        }
        return sol;
    }
}