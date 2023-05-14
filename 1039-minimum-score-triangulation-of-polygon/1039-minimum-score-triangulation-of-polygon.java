class Solution {
    public int minScoreTriangulation(int[] values) {
        int m=values.length;
        int dp[][]=new int[m+1][m+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int n=0;
        n=fn(values,0,m-1,dp);
        return n;
        
    }
    int fn(int arr[],int i ,int j,int [][]dp){
        if(i+1==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int num=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            num=Math.min(num,(arr[i]*arr[j]*arr[k])+fn(arr,i,k,dp)+fn(arr,k,j,dp));
        }
        dp[i][j]=num;
        return num;
    }
}