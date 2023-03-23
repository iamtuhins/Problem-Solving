//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinSquares(int n)
    {
        // Code here
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int m=fn(n,dp);
        return m;
    }
    int fn(int num,int[]dp){
        if(0>=num){
            return 0;
        }
        if(dp[num]!=-1){
            return dp[num];
        }
        int temp=num;
        for(int i=1;i*i<=num;i++){
            temp=Math.min(temp,1+fn(num-(i*i),dp));
        }
        dp[num]=temp;
        return temp;
    }
}