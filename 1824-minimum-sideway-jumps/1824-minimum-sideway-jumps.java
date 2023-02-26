class Solution {
    public int minSideJumps(int[] obstacles) {
        int dp[][]=new int[obstacles.length+1][4];
        for(int i=0;i<obstacles.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int m=fn(obstacles,0,2,dp);
        return m;
        
    }
    int fn(int arr[],int id,int pnt,int [][]dp){
        if(id>=arr.length-1){
            return 0;
        }
        if(arr[id+1]!=pnt){
         return fn(arr,id+1,pnt,dp);   
        }
        if(dp[id][pnt]!=-1){
            return dp[id][pnt];
        }
        int temp=Integer.MAX_VALUE;
        for(int i=1;i<=3;i++){
            if(pnt!=i && arr[id]!=i){
                temp=Math.min(temp,1+fn(arr,id,i,dp));
            }
        }
        dp[id][pnt]=temp;
        return temp;
    }
}