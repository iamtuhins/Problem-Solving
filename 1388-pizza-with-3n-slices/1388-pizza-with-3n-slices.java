class Solution {
    public int maxSizeSlices(int[] slices) {
        int m=slices.length;
        int vl=m/3;
        int dp[][]=new int[m+1][vl+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int f1=fn(slices,0,m-1,vl,dp);
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        int f2=fn(slices,1,m,vl,dp);
        int n=Math.max(f1,f2);
        return n;
        
    }
    int fn(int arr[],int id, int eId,int nm,int [][]dp){
        if(id>=eId || 0>=nm){
            return 0;
        }
        if(dp[id][nm]!=-1){
            return dp[id][nm];
        }
        int adding=arr[id]+fn(arr,id+2,eId,nm-1,dp);
        int notAdding=0+fn(arr,id+1,eId,nm,dp);
        int temp=Math.max(adding,notAdding);
        dp[id][nm]=temp;
        return temp;
    }
}