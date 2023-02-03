class Solution {
    public int minSideJumps(int[] obstacles) {
        int dp[][]=new int[3+1][obstacles.length];
        for(int i=0;i<=3;i++){
            Arrays.fill(dp[i],-1);
        }
        int n=fn(obstacles,2,0,dp);
        return n;
        
    }
    int fn(int arr[],int lane,int pos,int [][]dp){
        if(pos==arr.length-1){
            return 0;
        }
        if(dp[lane][pos]!=-1){
            return dp[lane][pos];
        }
        if(arr[pos+1]!=lane){
            return fn(arr,lane,pos+1,dp);
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=3;i++){
            if(i!=lane && arr[pos]!=i){
                min=Math.min(min,1+fn(arr,i,pos,dp));
            }
        }
        dp[lane][pos]=min;
        return min;
    }
}