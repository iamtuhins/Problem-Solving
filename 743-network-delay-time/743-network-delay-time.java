class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>>adj=new ArrayList<>();
        int distt[]=new int[n+1];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        for(int i=0;i<=n;i++){
            distt[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Pair>p=new PriorityQueue<>();
        p.add(new Pair(k,0));
        distt[k]=0;
        while(!p.isEmpty()){
            Pair pp=p.poll();
            int num1=pp.nd;
            int dist1=pp.dist;
            for(Pair tm: adj.get(num1)){
                int num=tm.nd;
                int dist=tm.dist;
                if(distt[num]>dist+dist1){
                    Pair temp=new Pair(num,dist+dist1);
                    if(p.contains(temp)){
                        p.remove(temp);
                    }
                    p.add(new Pair(num,dist1+dist));
                    distt[num]=dist+dist1;
                }
            }
        }
        int sol=0;
        for(int i=1;i<=n;i++){
            if(distt[i]!=Integer.MAX_VALUE){
                sol=Math.max(distt[i],sol);
            }else{
                return -1;
            }
        }
        return sol;
        
    }
}
class Pair implements Comparable<Pair>{
    int nd;
    int dist;
    Pair(int n,int d){
        this.nd=n;
        this.dist=d;
    }
    public int compareTo(Pair ob){
        return ob.dist-this.dist;
    }
}