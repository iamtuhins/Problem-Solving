// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vist[]=new int[V];
        Map<Integer,Integer>map=new HashMap<>();
        boolean sol[]=new boolean[1];
        for(int i=0;i<V;i++){
            if(vist[i]==0){
                map.put(i,-1);
                dfs(adj,i,sol,map,vist);
            if(sol[0]==true){
                return true;
            }
            }
        }
        return false;
    }
    void dfs(ArrayList<ArrayList<Integer>>adj,int node,boolean arr[],
    Map<Integer,Integer>map,int vist[]){
        vist[node]=1;
        for(int n: adj.get(node)){
            if(vist[n]==1 && map.get(node)!=n){
                arr[0]=true;
                return;
            }else if(vist[n]==0){
                map.put(n,node);
                dfs(adj,n,arr,map,vist);
            }
        }
    }
    boolean bfs(int node,ArrayList<ArrayList<Integer>>adj,int[]vist,Map<Integer,Integer>map){
        Queue<Integer>q=new LinkedList<>();
        q.add(node);
        vist[node]=1;
        map.put(node,-1);
        while(!q.isEmpty()){
            int n=q.remove();
            for(int m: adj.get(n)){
                if(vist[m]==1 && map.get(n)!=m){
                    return true;
                }else if(vist[m]==0){
                    vist[m]=1;
                    q.add(m);
                    map.put(m,n);
                }
            }
        }
        return false;
    }
}