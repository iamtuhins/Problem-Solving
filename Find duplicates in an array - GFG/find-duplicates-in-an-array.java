//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        int idN=0;
        while(idN<n){
            int temp=arr[idN];
            if(arr[temp]==temp){
                idN++;
            }else{
                arr[idN]=arr[temp];
                arr[temp]=temp;
            }
        }
        
        ArrayList<Integer>sol=new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp=arr[i];
            if(temp!=-1 && temp!=i){
               if(arr[temp]!=-1){
                sol.add(temp);
                arr[temp]=-1;
               }
            }
        }
        Collections.sort(sol);
        int m=sol.size();
        if(m==0){
            sol.add(-1);
        }
        return sol;
    }
}
