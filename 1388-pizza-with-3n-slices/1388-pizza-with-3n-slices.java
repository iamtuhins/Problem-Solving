class Solution {
    public int maxSizeSlices(int[] slices) {
        int k=slices.length;
        int m=k/3;
        int dp[][]=new int[k+1][m+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int case1= fn(slices,0,m,k-1,dp);
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int case2= fn(slices,1,m,k,dp);
        int n=Math.max(case1,case2);
        return n;
        
    }
    int fn(int []arr,int id,int m,int endId,int [][]dp){
        if(id>=endId || m==0){
            return 0;
        }
        if(dp[id][m]!=-1){
            return dp[id][m];
        }
        int take=arr[id]+fn(arr,id+2,m-1,endId,dp);
        int notTake=0+fn(arr,id+1,m,endId,dp);
        int temp=Math.max(take,notTake);
        dp[id][m]=temp;
        return temp;
    }
}