class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int m=fn(days,costs,n,0,dp);
        return m;
    }
    int fn(int []days,int cost[],int n,int id,int[] dp){
        if(id>=n){
            return 0;
        }
        int i=0;
        if(dp[id]!=-1){
            return dp[id];
        }
        int oneDay=cost[0]+fn(days,cost,n,id+1,dp);
        for(i=id;i<n && days[i]<days[id]+7;i++);
        int sevenDays=cost[1]+fn(days,cost,n,i,dp);
        for(i=id;i<n && days[i]<days[id]+30;i++);
        int ThirtyDays=cost[2]+fn(days,cost,n,i,dp);
        int temp=Math.min(oneDay,Math.min(sevenDays,ThirtyDays));
        dp[id]=temp;
        return temp;
    }
}