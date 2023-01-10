class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int s1=fn(dp,cost,0);
        int s2=fn(dp,cost,1);
        int sol=Math.min(s1,s2);
        return sol;
        
    }
    int fn(int dp[],int cost[],int m){
        if(m>=cost.length-1){
            if(m==cost.length-1){
               return cost[m];
            }
            return 0;
        }
        if(dp[m]!=-1){
            return dp[m];
        }
        dp[m]=cost[m]+Math.min(fn(dp,cost,m+1),fn(dp,cost,m+2));
        return dp[m];
    }
}