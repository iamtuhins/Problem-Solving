// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vist[]=new int[V];
        int now[]=new int[V];
        for(int i=0;i<V;i++){
            if(vist[i]==0){
                boolean sol=false;
                sol=dfs(adj,vist,now,i);
                if(sol==true){
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(ArrayList<ArrayList<Integer>>adj,int vist[],int []now,int node){
        vist[node]=1;
        now[node]=1;
        for(int n: adj.get(node)){
            if(vist[n]==1 && now[n]==1){
                return true;
            }else if(vist[n]==0){
                boolean temp=dfs(adj,vist,now,n);
                if(temp){
                    return true;
                }
            }
        }
        now[node]=0;
        return false;
    }
}