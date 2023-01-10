class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int sol=fn(new int[1],n,0,dp);
        return sol;
        
    }
    int fn(int []arr,int n,int m,int []dp){
        if(m>=n){
            if(m==n){
                 return 1;
            }
            return 0;
        }
        if(dp[m]>-1){
            return dp[m];
        }
        dp[m]= fn(arr,n,m+1,dp)+fn(arr,n,m+2,dp);
        return dp[m];
    }
}