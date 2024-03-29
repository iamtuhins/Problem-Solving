//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int mn=fn(price,n,dp);
        return mn;
    }
    int fn(int price[],int n,int dp[]){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int num=0;
        for(int i=0;i<n;i++){
            int temp=price[i]+fn(price,n-(i+1),dp);
            if(temp>num){
                num=temp;
            }
        }
        dp[n]=num;
        return dp[n];
    }
}