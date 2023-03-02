class Solution {
    public int maximalSquare(char[][] matrix) {
        int mz[]=new int[1];
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int sol=fn(matrix,0,0,mz,dp);
        int temp=mz[0]*mz[0];
        return temp;
    }
    int fn(char arr[][],int n,int m,int []mz,int [][]dp){
        if(n>=arr.length || m>=arr[0].length){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        int lf=fn(arr,n,m+1,mz,dp);
        int conn=fn(arr,n+1,m+1,mz,dp);
        int ryt=fn(arr,n+1,m,mz,dp);
        if(arr[n][m]=='1'){
            int temp=1+Math.min(lf,Math.min(conn,ryt));
            dp[n][m]=temp;
            mz[0]=Math.max(mz[0],temp);
            return temp;
        }else{
            return 0;
        }
    }
}