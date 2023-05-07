class Solution {
    public int minSideJumps(int[] obstacles) {
        int m=obstacles.length;
        int row=2;
        int colm=0;
        int dp[][]=new int[4][m+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int n= fn(obstacles,colm,row,dp);
        return n;
        
    }
    int fn(int arr[],int colm,int row,int [][]dp){
        if(colm>=arr.length-1){
            return 0;
        }
        if(dp[row][colm]!=-1){
            return dp[row][colm];
        }
        if(arr[colm+1]!=row){
            return dp[row][colm]= fn(arr,colm+1,row,dp);
        }
        int temp=Integer.MAX_VALUE;
        for(int i=1;i<=3;i++){
            if(arr[colm]!=i && row!=i){
                temp=Math.min(temp,1+fn(arr,colm,i,dp));
            }
        }
        dp[row][colm]=temp;
        return temp;
    }
}