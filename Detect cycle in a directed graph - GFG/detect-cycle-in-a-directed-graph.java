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
        int vistMn[]=new int[V];
        for(int i=0;i<V;i++){
            if(vist[i]==0){
                boolean temp=false;
                temp=fn(i,vist,adj,vistMn);
                if(temp){
                    return true;
                }
            }
        }
        return false;
    }
    boolean fn(int n,int []vist,ArrayList<ArrayList<Integer>>adj,int []vistMn){
        vist[n]=1;
        vistMn[n]=1;
        for(int node: adj.get(n)){
            if(vist[node]==0){
                boolean temp=false;
                temp=fn(node,vist,adj,vistMn);
                if(temp){
                    return true;
                }
            }else if(vist[node]==1 && vistMn[node]==1){
                return true;
            }
        }
        vistMn[n]=0;
        return false;
    }
}