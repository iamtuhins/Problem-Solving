class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        int sol=fn(dp,0,0,m,n);
        return sol;
    }
    int fn(int dp[][],int n,int m,int n1,int m1){
        if(n>=n1 || m>=m1){
            return 0;
        }
        if(dp[n][m]!=0){
            return dp[n][m];
        }
        if(n==n1-1 && m==m1-1){
            return 1;
        }
        int t1=fn(dp,n+1,m,n1,m1);
        int t2=fn(dp,n,m+1,n1,m1);
        dp[n][m]=t1+t2;
        return dp[n][m];
    }
}