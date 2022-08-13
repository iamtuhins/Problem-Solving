class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        int sol=0;
        int dist[][]={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                Pair temp=q.remove();
                for(int j=0;j<4;j++){
                    int idn=temp.n;
                    int idm=temp.m;
                    idn=idn+dist[j][0];
                    idm=idm+dist[j][1];
                    if(idn>=0 && idm>=0 && idn<grid.length && idm<grid[0].length && grid[idn][idm]==1){
                        q.add(new Pair(idn,idm));
                        grid[idn][idm]=-1;
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