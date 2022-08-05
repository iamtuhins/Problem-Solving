class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int dp[]=new int[target+1];
        int temp=0;
        Arrays.fill(dp,-1);
        fn(nums,dp,target);
        return dp[target];
        
        
    }
    int fn(int nums[],int dp[],int target){
        if(target<0){
            return 0;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        if(target==0){
            return 1;
        }
        int sol=0;
        for(int i=0;i<nums.length;i++){
            sol=sol+fn(nums,dp,target-nums[i]);
        }
        dp[target]=sol;
        return sol;
    }
}