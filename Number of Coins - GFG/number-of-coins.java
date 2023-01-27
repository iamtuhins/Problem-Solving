//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    int dp[]=new int[V+1];
	    Arrays.fill(dp,-1);
	    int n=fn(coins,M,V,0,dp);
	    if(n==Integer.MAX_VALUE){
	        return -1;
	    }
	    return n; 
	} 
	int fn(int arr[],int M,int V,int id,int []dp){
	   if(0>V){
	       return Integer.MAX_VALUE;
	   }
	   if(0==V){
	       return 0;
	   }
	   if(dp[V]!=-1){
	       return dp[V];
	   }
	    int val=Integer.MAX_VALUE;
	    for(int i=0;i<M;i++){
	        int temp=fn(arr,M,V-arr[i],i,dp);
	        if(temp!=Integer.MAX_VALUE){
	            val=Math.min(val,temp+1);
	        }
	    }
	    dp[V]=val;
	    return dp[V];
	}
}