class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length_t1=text1.length();
        int length_t2=text2.length();
        int dp[][]=new int[length_t1+1][length_t2+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int n=fn(text1,text2,0,0,dp);
        return n;
        
        
    }
    int fn(String st1, String st2, int id1, int id2,int [][]dp){
        if(id1>=st1.length() || id2>=st2.length()){
            return 0;
        }
        if(dp[id1][id2]!=-1){
            return dp[id1][id2];
        }
        int n=0;
        int temp1=0;
        int temp2=0;
        int temp3=0;
        if(st1.charAt(id1)==st2.charAt(id2)){
            temp1=1+fn(st1,st2,id1+1,id2+1,dp);
        }else{
            temp2=0+fn(st1,st2,id1+1,id2,dp);
            temp3=0+fn(st1,st2,id1,id2+1,dp);
        }
        n=Math.max(temp1,Math.max(temp2,temp3));
        dp[id1][id2]=n;
        return n;
    }
}