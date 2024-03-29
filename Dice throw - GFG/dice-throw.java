//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            int X = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.noOfWays(M,N,X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long noOfWays(int M , int N , int X) {
        // code here
        long dp[][]=new long[N+1][X+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        long n=fn(N,M,X,dp);
        return n;
    }
    static long fn(int n,int m,int z,long dp[][]){
       if(n==0 && z!=0){
           return 0;
       }else if(z==0 && n!=0){
           return 0;
       }else if(0>z){
           return 0;
       }
       if(n==0 && z==0){
           return 1;
       }
       if(dp[n][z]!=-1){
           return dp[n][z];
       }
        long temp=0;
        for(int i=1;i<=m;i++){
            temp+=fn(n-1,m,z-i,dp);
        }
        dp[n][z]=temp;
        return temp;
    }
};