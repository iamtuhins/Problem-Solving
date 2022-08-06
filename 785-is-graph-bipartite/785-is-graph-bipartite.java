class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int vist[]=new int[n];
        Arrays.fill(vist,-1);
        for(int i=0;i<n;i++){
            if(vist[i]==-1){
                Queue<Pair>q=new LinkedList<>();
                vist[i]=1;
                q.add(new Pair(i,1));
                while(!q.isEmpty()){
                    Pair p=q.remove();
                    int id=p.id;
                    int nums=p.nums;
                    for(int temp: graph[id]){
                        if(vist[temp]==-1){
                            int m2=1-nums;
                            vist[temp]=m2;
                            Pair pt=new Pair(temp,m2);
                            q.add(pt);
                        }else if(vist[temp]==nums){
                            return false;
                        }
                    }
                }
            }
            
        }
        return true;
        
    }
}
class Pair{
    int id;
    int nums;
    Pair(int n,int m){
        this.id=n;
        this.nums=m;
    }
}