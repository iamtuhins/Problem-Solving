//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxSquare(int n, int m, int mat[][]){
        // code here
        int mz[]=new int[1];
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int j=fn(mat,0,0,mz,dp);
        return mz[0];
    }
    static int fn(int arr[][],int n, int m,int []mz,int [][]dp){
        if(n>=arr.length || m>=arr[0].length){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        int lf=fn(arr,n,m+1,mz,dp);
        int conn=fn(arr,n+1,m+1,mz,dp);
        int ryt=fn(arr,n+1,m,mz,dp);
        int temp=0;
        if(arr[n][m]==1){
            temp=1+Math.min(lf,Math.min(conn,ryt));
            dp[n][m]=temp;
            mz[0]=Math.max(mz[0],temp);
            return temp;
        }else{
            dp[n][m]=0;
            return 0;
        }
    }
}