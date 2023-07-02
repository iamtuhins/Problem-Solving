class Solution {
    public int maxProfit(int[] prices) {
        int m=0;
        int min=prices[0];
        int diff=0;
        for(int i=1;i<prices.length;i++){
            diff=prices[i]-min;
            m=Math.max(m,diff);
            min=Math.min(min,prices[i]);
        }
        return m;
        
    }
}