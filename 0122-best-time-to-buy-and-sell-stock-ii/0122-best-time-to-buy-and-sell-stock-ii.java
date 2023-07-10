class Solution {
    public int maxProfit(int[] prices) {
        int m=prices.length;
        int buy=0;
        int dp[][]=new int[m+1][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int n=fn(prices,0,buy,dp);
        return n;
        
    }
    int fn(int []arr,int id,int buy,int [][]dp){
        if(id>=arr.length){
            return 0;
        }
        if(dp[id][buy]!=-1){
            return dp[id][buy];
        }
        int n=0;
        if(buy==0){
            int temp1=-arr[id]+fn(arr,id+1,1,dp);
            int temp2=0+fn(arr,id+1,0,dp);
            n=Math.max(temp1,temp2);
        }else{
            int temp1=arr[id]+fn(arr,id+1,0,dp);
            int temp2=0+fn(arr,id+1,1,dp);
            n=Math.max(temp1,temp2);
        }
        dp[id][buy]=n;
        return n;
    }
}