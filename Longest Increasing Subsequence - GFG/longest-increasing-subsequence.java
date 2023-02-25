//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        int dp[][]=new int[size+1][size+1];
        for(int i=0;i<size;i++){
            Arrays.fill(dp[i],-1);
        }
        int n=fn(a,-1,0,dp);
        return n;
    }
    static int fn(int arr[],int prevId,int currId,int [][]dp){
        if(currId>=arr.length){
            return 0;
        }
        if(dp[currId][prevId+1]!=-1){
            return dp[currId][prevId+1];
        }
        int adding=0;
        if(prevId==-1 || arr[currId]>arr[prevId]){
            adding=1+fn(arr,currId,currId+1,dp);
        }
        int notAdding=0+fn(arr,prevId,currId+1,dp);
        int temp=Math.max(adding,notAdding);
        dp[currId][prevId+1]=temp;
        return temp;
    }
} 