class Solution {
    public int longestPalindromeSubseq(String s) {
        int m=s.length();
        int dp[][]=new int[m+1][m+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        if(m==1){
            return 1;
        }
        int n=fn(s,0,m-1,dp);
        return n;
        
        
    }
    int fn(String st,int idn,int idm,int [][]dp){
        if(idn==idm){
            return 1;
        }
        if(idn>idm){
            return 0;
        }
        if(dp[idn][idm]!=-1){
            return dp[idn][idm];
        }
        int n=0;
        int temp1=0;
        int temp2=0;
        int temp3=0;
        if(st.charAt(idn)==st.charAt(idm)){
            temp1=2+fn(st,idn+1,idm-1,dp);
        }else{
            temp2=0+fn(st,idn+1,idm,dp);
            temp3=0+fn(st,idn,idm-1,dp);
        }
        n=Math.max(temp1,Math.max(temp2,temp3));
        dp[idn][idm]=n;
        return n;
    }
}