class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[]=new int[target+1];
        Arrays.fill(dp,-1);
        int n=fn(nums,target,dp);
        return n;
        
    }
    int fn(int arr[],int vals,int dp[]){
        if(vals==0){
            return 1;
        }
        if(0>vals){
            return 0;
        }
        if(dp[vals]!=-1){
            return dp[vals];
        }
        int temp=0;
        for(int i=0;i<arr.length;i++){
            temp+=fn(arr,vals-arr[i],dp);
        }
        dp[vals]=temp;
        return temp;
    }
}