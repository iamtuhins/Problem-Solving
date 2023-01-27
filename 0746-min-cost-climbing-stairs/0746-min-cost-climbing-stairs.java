class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp,-1);
        int m=fn(cost,0,dp);
        int n=fn(cost,1,dp);
        int sol=Math.min(m,n);
        return sol;
        
    }
    int fn(int []cost,int id,int dp[]){
        if(id>=cost.length){
            return 0;
        }
        if(dp[id]!=-1){
            return dp[id];
        }
        int tm1=cost[id]+fn(cost,id+1,dp);
        int tm2=cost[id]+fn(cost,id+2,dp);
        int temp=Math.min(tm1,tm2);
        dp[id]=temp;
        return dp[id];
    }
}