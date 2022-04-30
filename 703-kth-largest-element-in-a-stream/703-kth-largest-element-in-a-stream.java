class KthLargest {
    List<Integer>ls=new ArrayList<>();
    int k;

    public KthLargest(int k, int[] nums) {
        for(int i=0;i<nums.length;i++){
            ls.add(nums[i]);
        }
        this.k=k;
    }
    
    public int add(int val) {
        ls.add(val);
        Collections.sort(ls);
        return ls.get(ls.size()-k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */