class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n=nums.length;
        int prev[]=new int[n];
        int next[]=new int[n];
        Arrays.fill(prev,1);
        Arrays.fill(next,1);
        for(int i=1;i<n;i++){
            if(nums[i-1]>=nums[i]){
                prev[i]=prev[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(nums[i+1]>=nums[i]){
                next[i]=next[i+1]+1;
            }
        }
        List<Integer>sol=new ArrayList<>();
        for(int i=k;i<n-k;i++){
            if(prev[i-1]>=k && next[i+1]>=k){
                sol.add(i);
            }
        }
        return sol;
    }
}