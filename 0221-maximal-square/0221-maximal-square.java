class Solution {
    public int maximalSquare(char[][] matrix) {
        int m[]=new int[1];
        int n=matrix.length;
        int j=matrix[0].length;
        int dp[][]=new int[n+1][j+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int temp=fn(matrix,0,0,m,dp);
        return m[0]*m[0];
    }
    int fn(char arr[][],int idN,int idM,int val[],int [][]dp){
        if(idN>=arr.length ||  idM>=arr[0].length){
            return 0;
        }
        if(dp[idN][idM]!=-1){
            return dp[idN][idM];
        }
        int lft=fn(arr,idN,idM+1,val,dp);
        int conn=fn(arr,idN+1,idM+1,val,dp);
        int ryt=fn(arr,idN+1,idM,val,dp);
        if(arr[idN][idM]=='1'){
            int temp=1+Math.min(lft,Math.min(conn,ryt));
            val[0]=Math.max(val[0],temp);
            dp[idN][idM]=temp;
            return temp;
        }else{
            dp[idN][idM]=0;
           return 0;
        }
    }
}