class Solution {
    public int jump(int[] nums) {
        int dp[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=-1;
        }
        return fn(nums,0,dp);
        
        
    }
    
    int fn(int arr[],int id,int dp[]){
        if(id>=arr.length-1){
            return 0;
        }
        if(dp[id]>0){
            return dp[id];
        }
        int sol=101010;
        for(int i=1;i<=arr[id];i++){
            int temp=fn(arr,id+i,dp)+1;
            sol=Math.min(sol,temp);
        }
        dp[id]=sol;
        return sol;
    }
}