class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vist[][]=new boolean[n][m];
        int sol=0;
        Queue<Pair>q=new LinkedList<>();
        int dirt[][]={{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vist[i][j]==false){
                    int tm=fn(grid,vist,i,j,q,dirt);
                    sol=Math.max(tm,sol);
                }
            }
        }
        return sol;
        
    }
    int fn(int [][]grid,boolean [][]vist,int idn,int idm,Queue<Pair>q,int [][]dirt){
        vist[idn][idm]=true;
        q.add(new Pair(idn,idm));
        int nums=0;
        while(!q.isEmpty()){
            int sz=q.size();
            nums=nums+sz;
            for(int i=0;i<sz;i++){
                Pair temp=q.remove();
                int nowRow=temp.nRow;
                int nowColm=temp.nColm;
                for(int j=0;j<4;j++){
                    int putRow=nowRow+dirt[j][0];
                    int putColm=nowColm+dirt[j][1];
                    if(putRow>=0 && putColm>=0 && putRow<grid.length && putColm<grid[0].length){
                        if(grid[putRow][putColm]==1 && vist[putRow][putColm]==false){
                            q.add(new Pair(putRow,putColm));
                            vist[putRow][putColm]=true;
                        }
                    }
                }
            }
        }
        return nums;
    }
}
class Pair{
    int nRow;
    int nColm;
    Pair(int n,int m){
        this.nRow=n;
        this.nColm=m;
    }
}