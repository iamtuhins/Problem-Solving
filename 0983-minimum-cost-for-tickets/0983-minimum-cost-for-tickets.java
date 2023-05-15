class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int m=days.length;
        int dp[]=new int[m+1];
        Arrays.fill(dp,-1);
        int n=fn(days,costs,0,dp);
        return n;
        
    }
    int fn(int []days,int []cost,int idm,int []dp){
        if(idm>=days.length){
            return 0;
        }
        if(dp[idm]!=-1){
            return dp[idm];
        }
        int val=0;
        int oneDay=cost[0]+fn(days,cost,idm+1,dp);
        int id=0;
        for(id=idm;id<days.length && days[id]<days[idm]+7;id++);
        int sevenDays=cost[1]+fn(days,cost,id,dp);
        for(id=idm;id<days.length && days[id]<days[idm]+30;id++);
        int Months=cost[2]+fn(days,cost,id,dp);
        int temp=Math.min(oneDay,Math.min(sevenDays,Months));
        dp[idm]=temp;
        return temp;
    }
}