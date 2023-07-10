class Solution {
    public int maxProfit(int[] prices) {
        int m=prices.length;
        int dp[][][]=new int[m+1][2][3];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int n=fn(prices,0,1,2,dp);
        return n;
        
        
    }
    int fn(int arr[],int id,int buy, int buySell,int [][][]dp){
        if(id>=arr.length || buySell==0){
            return 0;
        }
        if(dp[id][buy][buySell]!=-1){
            return dp[id][buy][buySell];
        }
        int n=0;
        if(buy==1){
            int temp1=-arr[id]+fn(arr,id+1,0,buySell,dp);
            int temp2=0+fn(arr,id+1,buy,buySell,dp);
            n=Math.max(temp1,temp2);
        }else{
            int temp1=arr[id]+fn(arr,id+1,1,buySell-1,dp);
            int temp2=0+fn(arr,id+1,buy,buySell,dp);
            n=Math.max(temp1,temp2);
        }
        dp[id][buy][buySell]=n;
        return n;
    }
}