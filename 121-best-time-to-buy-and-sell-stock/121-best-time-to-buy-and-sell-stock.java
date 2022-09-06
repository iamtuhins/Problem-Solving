class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int sol=0;
        int high=prices[0];
        int low=high;
        for(int i=1;i<n;i++){
            if(low>prices[i]){
                low=prices[i];
                high=0;
            }else if(prices[i]>high && (prices[i]-low)>sol){
                high=prices[i];
                sol=high-low;
            }
        }
        return sol;
        
    }
}