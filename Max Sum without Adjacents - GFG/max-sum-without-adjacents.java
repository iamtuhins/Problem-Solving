//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int m=fn(arr,0,dp);
        return m;
    }
    int fn(int arr[],int id,int []dp){
        if(id>=arr.length){
            return 0;
        }
        if(dp[id]!=-1){
            return dp[id];
        }
        int val1=arr[id]+fn(arr,id+2,dp);
        int val2=fn(arr,id+1,dp);
        dp[id]=Math.max(val1,val2);
        return dp[id];
    }
}