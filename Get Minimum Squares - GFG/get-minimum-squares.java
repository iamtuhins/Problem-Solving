//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinSquares(int n)
    {
        // Code here
        int map[]=new int[n+1];
        Arrays.fill(map,-1);
        int sol=fn(n,map);
        return sol;
    }
    int fn(int n,int []map){
        if(0>=n){
            return 0;
        }
        if(map[n]!=-1){
            return map[n];
        }
        int temp=n;
        for(int i=1;i*i<=n;i++){
            temp=Math.min(temp,1+fn(n-(i*i),map));
        }
        map[n]=temp;
        return temp;
    }
}