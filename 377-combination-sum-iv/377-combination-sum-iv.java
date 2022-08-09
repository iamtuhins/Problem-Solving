class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int dp[]=new int[target+1];
        for(int i=0;i<=target;i++){
            dp[i]=-1;
        }
        int sol=fn(nums,dp,target);
        return sol;
        
    }
    int fn(int []nums,int []dp,int target){
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