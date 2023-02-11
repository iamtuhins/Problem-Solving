class Solution {
    public int maxSatisfaction(int[] satisfaction) {
       Arrays.sort(satisfaction);
        int n=satisfaction.length;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int sol=fn(satisfaction,0,1,dp);
        return sol;
    }
    int fn(int []satisfaction,int id, int timing,int [][]dp){
        if(id>=satisfaction.length){
            return 0;
        }
        if(dp[id][timing]!=-1){
            return dp[id][timing];
        }
        int adding=(satisfaction[id]*timing)+fn(satisfaction,id+1,timing+1,dp);
        int notAdding=fn(satisfaction,id+1,timing,dp);
        int sol=Math.max(adding,notAdding);
        dp[id][timing]=sol;
        return sol;
    }
}