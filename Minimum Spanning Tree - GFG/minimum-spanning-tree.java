//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    int vist[]=new int[V];
	    PriorityQueue<Pair>pq=new PriorityQueue<>((n,m)-> n.wt-m.wt);
	    pq.add(new Pair(0,0));
	    List<List<Pair>>adj=new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<Pair>());
	    }
	    for(int i=0;i<E;i++){
	        int n=edges[i][0];
	        int m=edges[i][1];
	        int w=edges[i][2];
	        adj.get(n).add(new Pair(m,w));
	        adj.get(m).add(new Pair(n,w));
	    }
	    int sol=0;
	    while(!pq.isEmpty()){
	        Pair p=pq.remove();
	        int nd=p.node;
	        int wt=p.wt;
	        if(vist[nd]==0){
	            vist[nd]=1;
	            sol=sol+wt;
	           for(Pair temp: adj.get(nd)){
	               if(vist[temp.node]==0){
	                   pq.add(new Pair(temp.node,temp.wt));
	               }
	           }
	        }
	    }
	    return sol;
	}
}
class Pair{
    int wt;
    int node;
    Pair(int n,int w){
        this.wt=w;
        this.node=n;
    }
}