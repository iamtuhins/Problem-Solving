class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n=nums.length;
        int dpLow[]=new int[n];
        int dpHigh[]=new int[n];
        Arrays.fill(dpLow,1);
        Arrays.fill(dpHigh,1);
        for(int i=1;i<n;i++){
            if(nums[i-1]>=nums[i]){
                dpLow[i]=dpLow[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(nums[i+1]>=nums[i]){
                dpHigh[i]=dpHigh[i+1]+1;
            }
        }
        List<Integer>sol=new ArrayList<>();
        for(int i=k;i<n-k;i++){
            if(dpLow[i-1]>=k && dpHigh[i+1]>=k){
                sol.add(i);
            }
        }
        return sol;
    }
}