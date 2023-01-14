class Solution {
    public int coinChange(int[] coins, int amount) {
        int sol;
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-1);
        sol=fn(coins,amount,dp);
        if(sol==Integer.MAX_VALUE){
            return -1;
        }
        return sol;
        
    }
     int fn(int coins[],int amount,int dp[]){
         if(amount==0){
             return 0;
         }
         if(amount<0){
             return Integer.MAX_VALUE;
         }
         if(dp[amount]!=-1){
             return dp[amount];
         }
         int min=Integer.MAX_VALUE;
         for(int i=0;i<coins.length;i++){
             int temp=fn(coins,amount-coins[i],dp);
             if(temp!=Integer.MAX_VALUE){
                 min=Math.min(min,1+temp);
             }
         }
         dp[amount]=min;
         return dp[amount];
     }
}