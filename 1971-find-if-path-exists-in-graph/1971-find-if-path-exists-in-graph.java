class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean sol;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vist[]=new int[n];
        Queue<Integer>q=new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            int temp=q.remove();
            vist[temp]=1;
            if(temp==destination){
                return true;
            }
            for(int nums: adj.get(temp)){
                if(nums==destination){
                    return true;
                }
                if(vist[nums]==0){
                    q.add(nums);
                }
            }
        }
        return false;
        
        
    }
    boolean fn(int vist[],int node,List<List<Integer>>adj,int dt){
        if(node==dt){
            return true;
        }
        vist[node]=1;
        for(int n: adj.get(node)){
            if(vist[n]==0){
                boolean temp=false;
                temp=fn(vist,n,adj,dt);
                if(temp){
                    return true;
                }
            }
        }
        return false;
    }
}