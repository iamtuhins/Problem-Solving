class Solution {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int m=fn(values,0,n-1,dp);
        return m;
    }
    int fn(int []arr,int n,int m,int dp[][]){
        if(n+1==m){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        int sol=Integer.MAX_VALUE;
        for(int k=n+1;k<m;k++){
            sol=Math.min(sol,arr[n]*arr[k]*arr[m]+fn(arr,n,k,dp)+fn(arr,k,m,dp));
        }
        dp[n][m]=sol;
        return dp[n][m];
    }
}