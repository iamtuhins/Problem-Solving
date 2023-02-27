class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int m=fn(n,dp);
        return m;
        
    }
    int fn(int n,int []dp){
        if(0>=n){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int temp=fn(n-1,dp)+fn(n-2,dp);
        dp[n]=temp;
        return temp;
    }
}