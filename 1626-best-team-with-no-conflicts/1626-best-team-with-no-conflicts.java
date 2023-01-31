class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=ages[i];
            arr[i][1]=scores[i];
        }
        Arrays.sort(arr,(p,m)-> p[0]==m[0]? p[1]-m[1]: p[0]-m[0]);
        int dp[]=new int[n];
        dp[0]=arr[0][1];
        for(int i=1;i<n;i++){
            int mz=arr[i][1];
            for(int j=0;j<i;j++){
                if(arr[i][1]>=arr[j][1]){
                    mz=Math.max(mz,dp[j]+arr[i][1]);
                }
            }
            dp[i]=mz;
        }
        int sol=0;
        for(int i=0;i<n;i++){
            sol=Math.max(sol,dp[i]);
        }
        return sol;
        
    }
}