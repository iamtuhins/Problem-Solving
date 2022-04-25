// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        int n=K;
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            Pair p=new Pair(i,0,arr[i][0]);
            pq.add(p);
        }
        ArrayList<Integer>sol=new ArrayList<>();
        while(pq.size()>=1){
            Pair p=pq.poll();
            sol.add(p.val);
            p.data_id++;
            if(p.data_id<n){
                p.val=arr[p.list_id][p.data_id];
                pq.add(p);
            }
        }
        return sol;
        
    }
}
class Pair implements Comparable<Pair>{
    int list_id;
    int data_id;
    int val;
    Pair(int li,int di,int val){
        this.list_id=li;
        this.data_id=di;
        this.val=val;
    }
    public int compareTo(Pair obj){
        return this.val-obj.val;
    }
    
}