class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1); 
        }
        int m=fn(satisfaction,0,1,dp);
        return m;
        
    }
    int fn(int arr[],int id, int num,int [][]dp){
        if(id>=arr.length){
            return 0;
        }
        if(dp[id][num]!=-1){
            return dp[id][num];
        }
        int adding=(arr[id]*num)+fn(arr,id+1,num+1,dp);
        int notAdding=0+fn(arr,id+1,num,dp);
        int temp=Math.max(adding,notAdding);
        dp[id][num]=temp;
        return temp;
    }
}