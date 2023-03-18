class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int m=fn(nums,0,dp);
        return m;
    }
    int fn(int []arr,int id,int []dp){
        if(id>=arr.length){
            return 0;
        }
        if(dp[id]!=-1){
            return dp[id];
        }
        int adding=arr[id]+fn(arr,id+2,dp);
        int notAdding=0+fn(arr,id+1,dp);
        int temp=Math.max(adding,notAdding);
        dp[id]=temp;
        return temp;
    }
}