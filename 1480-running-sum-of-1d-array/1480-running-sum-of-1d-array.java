class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int sol[]=new int[n];
        int m=0;
        for(int i=0;i<n;i++){
            m+=nums[i];
            sol[i]=m;
        }
        return sol;
        
    }
}