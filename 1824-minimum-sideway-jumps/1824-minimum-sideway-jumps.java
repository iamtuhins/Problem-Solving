class Solution {
    public int minSideJumps(int[] obstacles) {
        int dp[][]=new int[4][obstacles.length];
        for(int i=0;i<4;i++){
            Arrays.fill(dp[i],-1);
        }
        int n=fn(obstacles,2,0,dp);
        return n;
        
    }
    int fn(int []obstacles,int currlane,int currpos,int [][]dp){
        if(currpos==obstacles.length-1){
            return 0;
        }
        if(dp[currlane][currpos]!=-1){
            return dp[currlane][currpos];
        }
        if(obstacles[currpos+1]!=currlane){
            dp[currlane][currpos]= fn(obstacles,currlane,currpos+1,dp);
            return dp[currlane][currpos];
        }
        int mz=Integer.MAX_VALUE;
        for(int i=1;i<=3;i++){
            if(i!=currlane && obstacles[currpos]!=i){
                mz=Math.min(mz,1+fn(obstacles,i,currpos,dp));
            }
        }
        dp[currlane][currpos]=mz;
        return mz;
    }
}