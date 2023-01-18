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
         int map[][]=new int[W+1][n+1];
        for(int i=0;i<=W;i++){
            Arrays.fill(map[i],-1);
        }
         int m=fn(W,wt,val,n,0,map);
         return m;
    } 
    static int fn(int w,int []wt,int val[],int n,int j,int [][]map){
        if(0>w){
            return 0;
        }
        if(map[w][j]!=-1){
            return map[w][j];
        }
        int mz=0;
        for(int i=j;i<n;i++){
            int temp=0;
            if(w>=wt[i]){
                temp=val[i]+fn(w-wt[i],wt,val,n,i+1,map);
            }
            mz=Math.max(mz,temp);
        }
        map[w][j]=mz;
        return mz;
    }
}


