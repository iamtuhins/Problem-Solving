class Solution {
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return fn(nums,0,dp);
        
        
    }
    boolean fn(int nums[],int id,int dp[]){
        if(id>=nums.length){
            return true;
        }
        if(dp[id]!=-1){
            if(dp[id]==1){
                return true;
            }
            return false;
        }
        boolean fm=false;
        boolean sm=false;
        boolean tm=false;
        if(nums.length>id+1 && nums[id]==nums[id+1]){
            fm=fn(nums,id+2,dp);
        }
        if(nums.length>id+2 && nums[id]==nums[id+1] && nums[id]==nums[id+2]){
            sm=fn(nums,id+3,dp);
        }
        if(nums.length>id+2 && nums[id]==nums[id+1]-1 && nums[id+1]==nums[id+2]-1){
            tm=fn(nums,id+3,dp);
        }
        if(fm || sm || tm){
            dp[id]=1;
            return true;
        }
        dp[id]=0;
        return false;
        
    }
}