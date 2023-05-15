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
        int k=0;
        int []mz=new int[1];
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        fn(0,0,mat,mz,dp);
        return mz[0];
    }
    static int fn(int j, int i,int [][]mat,int []mz,int [][]dp){
        if(i>=mat.length || j>=mat[0].length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int rt=fn(j+1,i,mat,mz,dp);
        int conn=fn(j+1,i+1,mat,mz,dp);
        int dwn=fn(j,i+1,mat,mz,dp);
        int temp=0;
        if(mat[i][j]==1){
            temp=1+Math.min(rt,Math.min(conn,dwn));
            dp[i][j]=temp;
            mz[0]=Math.max(mz[0],temp);
        }else{
            dp[i][j]=0;
        }
        return temp; 
    }
}