class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int m=edges[0].length;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        int sol[]=new int[2];
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int vists[]=new int[n+1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            boolean temp=fn(adj,u,vists,-1);
            if(temp){
                sol[0]=u;
                sol[1]=v;
                return sol;
            }
        }
        return sol;
        
    }
    boolean fn(List<List<Integer>>adj,int id,int vists[],int pnt){
        vists[id]=1;
        for(int temp: adj.get(id)){
            if(vists[temp]==0){
             boolean tm=fn(adj,temp,vists,id);
                if(tm==true){
                    return true;
                }
            }else if(pnt!=temp){
                return true;
            }
        }
        return false;
    }
}