//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int m=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            m=m+arr[i];
        }
        if(m%2!=0){
            return 0;
        }
        int hlff=m/2;
        int dp[][]=new int[N+1][hlff+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int n=fn(arr,hlff,0,0,dp);
        return n;
    }
    static int fn(int []arr,int hlff, int idn,int sm,int [][]dp){
       if(idn>=arr.length || sm>hlff){
           return 0;
       }
       if(hlff==sm){
           return 1;
       }
       if(dp[idn][sm]!=-1){
           return -1;
       }
       int adding=fn(arr,hlff,idn+1,sm+arr[idn],dp);
       int notAdding=fn(arr,hlff,idn+1,sm,dp);
       if(adding==1 || notAdding==1){
           return dp[idn][sm]= 1;
       }
       dp[idn][sm]=0;
       return 0;
    }
}