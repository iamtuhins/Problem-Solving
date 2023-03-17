//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][]=new int[n+1][W+1];
         for(int i=0;i<n+1;i++){
             Arrays.fill(dp[i],-1);
         }
         int m=fn(W,0,val,wt,dp);
         return m;
    } 
    static int fn(int W,int id,int []val,int []wt,int [][]dp){
        if(0>=W || id>=wt.length){
            return 0;
        }
        if(dp[id][W]!=-1){
            return dp[id][W];
        }
        int adding=0;
        if(wt[id]<=W){
            adding=val[id]+fn(W-wt[id],id+1,val,wt,dp);
        }
        int notAdding=0+fn(W,id+1,val,wt,dp);
        int temp=Math.max(adding,notAdding);
        dp[id][W]=temp;
        return temp;
        
    }
}


