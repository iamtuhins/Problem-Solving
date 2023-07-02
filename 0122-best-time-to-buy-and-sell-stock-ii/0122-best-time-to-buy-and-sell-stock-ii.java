class Solution {
    public int maxProfit(int[] prices) {
        int n=0;
        int buy=1;
        int m=prices.length;
        int dp[][]=new int[m+1][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        n=fn(prices,0,buy,dp);
        return n;
        
        
    }
    int fn(int arr[],int id, int buy,int [][]dp){
        if(id>=arr.length){
            return 0;
        }
        if(dp[id][buy]!=-1){
            return dp[id][buy];
        }
        int profit=0;
        if(buy==1){
            int temp1= (-1*arr[id])+fn(arr,id+1,0,dp);
            int temp2=0+fn(arr,id+1,1,dp);
            profit=Math.max(temp1,temp2);
        }else{
            int temp1=arr[id]+fn(arr,id+1,1,dp);
            int temp2=0+fn(arr,id+1,0,dp);
            profit=Math.max(temp1,temp2);
        }
        dp[id][buy]=profit;
        return profit;
    }
}