class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int low[]=new int[n];
        int decs[]=new int[n];
        int parents=-1;
        List<List<Integer>>sol=new ArrayList<>();
        int times[]=new int[1];
        boolean vists[]=new boolean[n];
        List<List<Integer>>adjs=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjs.add(new ArrayList<Integer>());
        }
        for(int i=0;i<connections.size();i++){
            int u=connections.get(i).get(0);
            int v=connections.get(i).get(1);
            adjs.get(u).add(v);
            adjs.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            low[i]=-1;
            decs[i]=-1;
            
        }
        for(int i=0;i<n;i++){
            if(vists[i]==false){
                dfs(i,decs,low,vists,sol,adjs,parents,times);
            }
        }
        return sol;
        
    }
    void dfs(int node,int desc[],int low[],
             boolean []vists,List<List<Integer>>sol,List<List<Integer>>conn,int pt,int []times){
        vists[node]=true;
        low[node]=times[0];
        desc[node]=times[0];
        times[0]++;
        for(int n: conn.get(node)){
            if(n==pt){
                continue;
            }
            if(vists[n]==false){
                dfs(n,desc,low,vists,sol,conn,node,times);
                low[node]=Math.min(low[node],low[n]);
                if(low[n]>desc[node]){
                    List<Integer>temp=new ArrayList<>();
                    temp.add(node);
                    temp.add(n);
                    sol.add(new ArrayList<Integer>(temp));
                }
            }else{
                low[node]=Math.min(low[node],desc[n]);
            }
        }
        
    }
}