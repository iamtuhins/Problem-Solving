class Solution {
    public int getMoneyAmount(int n) {
        int m=0;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int start=1;
        int end=n;
        m=fn(start,end,dp);
        return m;
        
        
    }
    int fn(int start, int end,int [][]map){
        if(start>=end){
            return 0;
        }
        if(map[start][end]!=-1){
            return map[start][end];
        }
        int m=Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            m=Math.min(m,i+Math.max(fn(start,i-1,map),fn(i+1,end,map)));
        }
        map[start][end]=m;
        return m;
    }
    
}