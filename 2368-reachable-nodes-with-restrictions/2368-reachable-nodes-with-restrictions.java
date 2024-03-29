class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int j=edges[i][1];
            adj.get(u).add(j);
            adj.get(j).add(u);
        }
        int vist[]=new int[n];
        for(int i=0;i<restricted.length;i++){
            vist[restricted[i]]=-1;
        }
        fn(adj,vist,0);
        int sol=0;
        for(int i=0;i<n;i++){
            if(vist[i]==1){
                sol++;
            }
        }
        return sol;
        
        
        
    }
    void fn(List<List<Integer>>adj,int vist[],int idm){
        vist[idm]=1;
        for(int temp: adj.get(idm)){
            if(vist[temp]==0){
                fn(adj,vist,temp);
            }
        }
    }
}