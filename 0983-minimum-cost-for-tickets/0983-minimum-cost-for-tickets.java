class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int m=fn(n,days,costs,0,dp);
        return m;
    }
    int fn(int n,int days[],int []cost,int id,int dp[]){
        if(id>=n){
            return 0;
        }
        if(dp[id]!=-1){
            return dp[id];
        }
        int oneDayPass=cost[0]+fn(n,days,cost,id+1,dp);
        int i=0;
        for(i=id;i<n && days[i]<days[id]+7;i++);
        int sevenDaypass=cost[1]+fn(n,days,cost,i,dp);
        for(i=id;i<n && days[i]<days[id]+30;i++);
        int thdDayPass=cost[2]+fn(n,days,cost,i,dp);
        int sol=Math.min(oneDayPass,Math.min(sevenDaypass,thdDayPass));
        dp[id]=sol;
        return dp[id];
    }
}