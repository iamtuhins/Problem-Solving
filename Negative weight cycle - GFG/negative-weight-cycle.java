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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int wt[]=new int[n];
        for(int i=0;i<n;i++){
            wt[i]=Integer.MAX_VALUE;
        }
        wt[0]=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<edges.length;j++){
                int n1=edges[j][0];
                int n2=edges[j][1];
                int dst=edges[j][2];
                if(wt[n1]!=Integer.MAX_VALUE && wt[n1]+dst<wt[n2]){
                    wt[n2]=wt[n1]+dst;
                }
            }
        }
        for(int j=0;j<edges.length;j++){
                int n1=edges[j][0];
                int n2=edges[j][1];
                int dst=edges[j][2];
                if(wt[n1]!=Integer.MAX_VALUE && wt[n1]+dst<wt[n2]){
                   return 1;
                }
            }
            return 0;
    }
}