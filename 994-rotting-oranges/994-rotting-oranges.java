class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dirt[][]={{0,1},{1,0},{0,-1},{-1,0}};
        Queue<Pair>q=new LinkedList<>();
        int sol=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                Pair p=q.remove();
                int nowRow=p.n;
                int nowColm=p.m;
                for(int j=0;j<4;j++){
                    int putRow=nowRow+dirt[j][0];
                    int putColm=nowColm+dirt[j][1];
                    if(putRow>=0 && putColm>=0 && putRow<n && putColm<m){
                        if(grid[putRow][putColm]==1){
                            grid[putRow][putColm]=2;
                            q.add(new Pair(putRow,putColm));
                        }
                    }
                }
            }
            if(q.size()>0){
                sol++;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return sol;
        
    }
}
class Pair{
    int n;
    int m;
    Pair(int n1,int m1){
        this.n=n1;
        this.m=m1;
    }
}