class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int lowTime[]=new int[n];
        boolean vist[]=new boolean[n];
        int time[]=new int[1];
        int rlTime[]=new int[n];
        List<List<Integer>>sol=new ArrayList<>();
        int m=connections.size();
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++){
            int u=connections.get(i).get(0);
            int v=connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            lowTime[i]=-1;
            rlTime[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(vist[i]==false){
                fn(-1,vist,lowTime,rlTime,time,i,adj,sol);
            }
        }
        return sol;
        
    }
    void fn(int pnt,boolean vist[],int []lowTime,int[]rlTime,int[] time,int node,List<List<Integer>>con,List<List<Integer>>sol){
        vist[node]=true;
        lowTime[node]=time[0];
        rlTime[node]=time[0]++;
        for(int n: con.get(node)){
            if(n==pnt){
                continue;
            }
            if(vist[n]==false){
                fn(node,vist,lowTime,rlTime,time,n,con,sol);
                lowTime[node]=Math.min(lowTime[n],lowTime[node]);
                if(lowTime[n]>rlTime[node]){
                    List<Integer>temp=new ArrayList<>();
                    temp.add(node);
                    temp.add(n);
                    sol.add(new ArrayList<Integer>(temp));
                }
            }else{
                lowTime[node]=Math.min(lowTime[node],rlTime[n]);
            }
        }
    }
}