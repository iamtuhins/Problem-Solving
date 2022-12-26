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
        int sol[]=new int[n];
        for(int i=0;i<n;i++){
            sol[i]=Integer.MAX_VALUE;
        }
        sol[0]=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<edges.length;j++){
                int u=edges[j][0];
                int m=edges[j][1];
                int wt=edges[j][2];
                if(sol[u]!=Integer.MAX_VALUE && (sol[u]+wt)<sol[m]){
                    sol[m]=sol[u]+wt;
                }
            }
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int m=edges[i][1];
            int wt=edges[i][2];
            if(sol[u]!=Integer.MAX_VALUE && (sol[u]+wt)<sol[m]){
                return 1;
            }
        }
        return 0;
    }
}