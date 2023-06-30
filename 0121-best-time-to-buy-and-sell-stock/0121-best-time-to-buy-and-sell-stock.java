class Solution {
    public int maxProfit(int[] prices) {
        int n=0;
        int min=prices[0];
        int diff=0;
        for(int i=1;i<prices.length;i++){
            diff=prices[i]-min;
            n=Math.max(n,diff);
            min=Math.min(min,prices[i]);
        }
        return n;
    }
}