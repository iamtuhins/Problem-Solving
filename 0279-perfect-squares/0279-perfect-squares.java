class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int m=fn(n,dp);
        return m;
        
    }
    int fn(int n,int []dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int temp=n;
        for(int i=1;i*i<=n;i++){
            temp=Math.min(temp,1+fn(n-(i*i),dp));
        }
        dp[n]=temp;
        return temp;
    }
}