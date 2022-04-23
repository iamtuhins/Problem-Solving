class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
           pq.add(nums[i]); 
        }
        int sol=0;
        while(pq.size()>0){
            if(k==1){
                sol=pq.peek();
            }
            k--;
            pq.poll();
        }
        return sol;
        
    }
}