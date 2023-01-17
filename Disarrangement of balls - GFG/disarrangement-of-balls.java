//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.disarrange(N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int mod=(int)1e9+7;
    static long disarrange(int N){
        // code here
        long dp[]=new long[N+1];
        Arrays.fill(dp,-1);
        long m=fn(N,dp);
        return m;
    }
    static long fn(int n,long dp[]){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        long temp=(n-1)*(fn(n-1,dp)+fn(n-2,dp))%mod;
        dp[n]=temp;
        return temp;
    }
}