class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        int n=edges.length;
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        int sol[]=new int[2];
        Map<Integer,Integer>map=new HashMap<>();
        map.put(1,-1);
        for(int i=0;i<n;i++){
            int vist[]=new int[n+1];
            int u=edges[i][0];
            int v=edges[i][1];
            map.put(u,-1);
            if(u==v){
                sol[0]=u;
                sol[1]=v;
                return sol;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
            if(dfs(u,vist,adj,map,sol)){
                sol[0]=u;
                sol[1]=v;
                return sol;
            }
        }
        return sol;
    }
    boolean dfs(int node,int vist[],List<List<Integer>>adj,
                Map<Integer,Integer>map,int sol[]){
        vist[node]=1;
        for(int n: adj.get(node)){
            if(vist[n]==1 && map.get(node)!=n){
                return true;
            }else if(vist[n]==0){
                map.put(n,node);
                dfs(n,vist,adj,map,sol);
            }
        }
        return false;
    }
}