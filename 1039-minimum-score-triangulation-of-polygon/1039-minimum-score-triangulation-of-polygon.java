class Solution {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int m=fn(values,0,n-1,dp);
        return m;
        
    }
    int fn(int arr[],int i, int j,int [][]dp){
        if(i+1==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int temp=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            temp=Math.min(temp,arr[i]*arr[j]*arr[k]+fn(arr,i,k,dp)+fn(arr,k,j,dp));
        }
        dp[i][j]=temp;
        return temp;
    }
}