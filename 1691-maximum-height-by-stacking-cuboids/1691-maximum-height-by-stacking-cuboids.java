class Solution {
    public int maxHeight(int[][] cuboids) {
        for(int i=0;i<cuboids.length;i++){
            Arrays.sort(cuboids[i]);
        }
        Arrays.sort(cuboids,(n,m)-> n[0]==m[0]?(n[1]==m[1]?n[2]-m[2]:n[1]-m[1]):n[0]-m[0]);
        int sol=0;
        int n=cuboids.length;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        sol=fn(cuboids,-1,0,dp);
        return sol;
        
    }
    int fn(int [][]arr,int prevId,int currId,int [][]dp){
        if(currId==arr.length){
            return 0;
        }
        if(dp[currId][prevId+1]!=-1){
            return dp[currId][prevId+1];
        }
        int adding=0;
        if(prevId==-1 || (arr[currId][0]>=arr[prevId][0] && arr[currId][1]>=arr[prevId][1] && arr[currId][2]>=arr[prevId][2])){
            adding=arr[currId][2]+fn(arr,currId,currId+1,dp);
        }
        int notAdding=0;
        notAdding=0+fn(arr,prevId,currId+1,dp);
        int temp=Math.max(adding,notAdding);
        dp[currId][prevId+1]=temp;
        return temp;
    }
}