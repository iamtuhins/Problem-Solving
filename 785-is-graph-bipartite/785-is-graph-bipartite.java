class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int nodes[]=new int[n];
        for(int i=0;i<n;i++){
            nodes[i]=-1;
        }
        nodes[0]=-1;
        boolean sol=true;
        for(int i=0;i<n;i++){
            if(nodes[i]==-1){
                nodes[i]=0;
                boolean temp=fn(graph,i,-1,nodes);
                if(temp==false)
                    return false;
            }
        }
        return sol;
        
        
    }
    boolean fn(int graph[][],int id,int parent,int nodes[]){
       for(int nm: graph[id]){
           if(nodes[nm]==-1){
               nodes[nm]=1-nodes[id];
               boolean temp=fn(graph,nm,id,nodes);
               if(temp==false)
                   return false;
           }else if(nm!=parent && nodes[nm]==nodes[id]){
               return false;
           }
       }
        return true;
    }
}