class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n];
        int sol=fn(dp,cost,n);
        return sol;
        
    }
    int fn(int dp[],int cost[],int n){
        int prv2=cost[0];
        int prv1=cost[1];
        for(int i=2;i<n;i++){
            int cn=cost[i]+Math.min(prv2,prv1);
            prv2=prv1;
            prv1=cn;
        }
        return Math.min(prv2,prv1);
    }
}