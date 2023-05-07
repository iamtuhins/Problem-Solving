class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int m=satisfaction.length;
        Arrays.sort(satisfaction);
        int id=0;
        int dp[][]=new int[m+1][m+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        int n=fn(satisfaction,id,1,dp);
        return n;
        
    }
    int fn(int arr[],int id,int val,int[][]dp){
        if(id>=arr.length){
            return 0;
        }
        if(dp[id][val]!=-1){
            return dp[id][val];
        }
        int adding=0;
        int notAdding=0;
        adding=arr[id]*val+(fn(arr,id+1,val+1,dp));
        notAdding=0+fn(arr,id+1,val,dp);
        int sol=Math.max(adding,notAdding);
        dp[id][val]=sol;
        return sol;
    }
}