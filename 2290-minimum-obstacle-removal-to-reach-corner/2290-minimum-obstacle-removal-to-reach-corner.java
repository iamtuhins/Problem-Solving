class Solution {
    public int minimumObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vist[][]=new boolean[n][m];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0,0));
        int direct[][]={{0,1},{1,0},{0,-1},{-1,0}};
        while(!pq.isEmpty()){
            int sz=pq.size();
            for(int i=0;i<sz;i++){
                Pair temp=pq.poll();
                int nowRow=temp.nRow;
                int nowColm=temp.nColm;
                int nowVal=temp.val;
                for(int j=0;j<4;j++){
                    int putRow=nowRow+direct[j][0];
                    int putColm=nowColm+direct[j][1];
                    if(putRow==n-1 && putColm==m-1){
                        return nowVal;
                    }
                    if(putRow>=0 && putColm>=0 && putRow<n && putColm<m && vist[putRow][putColm]==false){
                        vist[putRow][putColm]=true;
                        if(grid[putRow][putColm]==0){
                            pq.add(new Pair(putRow,putColm,nowVal));
                        }else{
                            pq.add(new Pair(putRow,putColm,nowVal+1));
                        }
                    }
                }
            }
        }
        return -1;
        
    }
}
class Pair implements Comparable<Pair>{
    int nRow;
    int nColm;
    int val;
    Pair(int n,int m,int j){
        this.nRow=n;
        this.nColm=m;
        this.val=j;
    }
    public int compareTo(Pair ob){
        return this.val-ob.val;
    }
    
}