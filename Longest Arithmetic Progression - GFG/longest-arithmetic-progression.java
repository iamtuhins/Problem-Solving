//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    int lengthOfLongestAP(int[] A, int n) {
        // code here
        if(n<=2){
            return n;
        }
        int m=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                m=Math.max(m,2+fn(A,A[j]-A[i],i));
            }
        }
        return m;
    }
    int fn(int []arr,int diff,int idn){
        if(idn<0){
            return 0;
        }
        int m=0;
        for(int i=idn-1;i>=0;i--){
            if(arr[idn]-arr[i]==diff){
                m=Math.max(m,1+fn(arr,diff,i));
            }
        }
        return m;
    }
}
