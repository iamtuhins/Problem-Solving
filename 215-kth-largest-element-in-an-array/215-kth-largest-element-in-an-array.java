class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k;i<n;i++){
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        int sol=pq.peek();
        return sol;
    }
}