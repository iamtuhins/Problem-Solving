class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        if(n==1){
            return stones[0];
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int m1=pq.poll();
            int m2=pq.poll();
            if(m1!=m2){
                int temp=Math.abs(m1-m2);
                pq.add(temp);
            }
        }
        if(pq.size()>0){
            return pq.peek();
        }
        return 0;
        
    }
}