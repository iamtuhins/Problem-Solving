class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        int sol[]=new int[2];
        for(int i=0;i<edges.length;i++){
            int vist[]=new int[n+1];
            int u=edges[i][0];
            int v=edges[i][1];
            Map<Integer,Integer>map=new HashMap<>();
            map.put(u,-1);
            
            if(u==v){
                sol[0]=u;
                sol[1]=v;
                return sol;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
            if(dfs(u,adj,vist,map)){
                sol[0]=u;
                sol[1]=v;
                return sol;
            }
        }
        return sol;
        
        
    }
    boolean dfs(int node,List<List<Integer>>adj,int vist[],Map<Integer,Integer>map){
        vist[node]=1;
        for(int n: adj.get(node)){
            if(vist[n]==1 && map.get(node)!=n){
                return true;
            }else if(vist[n]==0){
                map.put(n,node);
                dfs(n,adj,vist,map);
            }
        }
        return false;
    }
}