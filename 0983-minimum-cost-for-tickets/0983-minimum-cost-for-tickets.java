class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int m=fn(days,costs,0,dp);
        return m;
        
    }
    int fn(int days[],int cost[],int idN,int []dp){
        if(idN>=days.length){
            return 0;
        }
        if(dp[idN]!=-1){
            return dp[idN];
        }
        int oneDayPass=cost[0]+fn(days,cost,idN+1,dp);
        int i=0;
        for(i=idN;i<days.length && days[i]<days[idN]+7;i++);
        int sevenDaysPass=cost[1]+fn(days,cost,i,dp);
        for(i=idN;i<days.length && days[i]<days[idN]+30;i++);
        int thirtyDaysPass=cost[2]+fn(days,cost,i,dp);
        int temp=Math.min(oneDayPass,Math.min(sevenDaysPass,thirtyDaysPass));
        dp[idN]=temp;
        return temp;
    }
}