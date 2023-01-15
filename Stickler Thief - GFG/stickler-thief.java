//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int sol;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        sol=fn(arr,0,dp);
        return sol;
    }
    int fn(int arr[],int id,int []dp){
        if(id>=arr.length){
            return 0;
        }
        if(dp[id]!=-1){
            return dp[id];
        }
        int n=fn(arr,id+2,dp)+arr[id];
        int m=fn(arr,id+1,dp);
        int temp=Math.max(n,m);
        dp[id]=temp;
        return temp;
        
    }
}