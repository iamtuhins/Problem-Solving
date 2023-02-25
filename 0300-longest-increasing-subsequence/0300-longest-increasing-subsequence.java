class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int m=fn(nums,-1,0,dp);
        return m;
        
    }
    int fn(int arr[],int prevId,int currId,int [][]dp){
        if(currId>=arr.length){
            return 0;
        }
        if(dp[currId][prevId+1]!=-1){
            return dp[currId][prevId+1];
        }
        int adding=0;
        if(prevId==-1 || arr[currId]>arr[prevId]){
            adding=1+fn(arr,currId,currId+1,dp);
        }
        int notAdding=fn(arr,prevId,currId+1,dp);
        int temp=Math.max(adding,notAdding);
        dp[currId][prevId+1]=temp;
        return temp;
    }
}