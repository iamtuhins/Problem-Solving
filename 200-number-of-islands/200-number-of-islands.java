class Solution {
    public int numIslands(char[][] grid) {
        int sol=0;
        int vst[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vst[i][j]==0 && grid[i][j]=='1'){
                    fn(grid,vst,i,j);
                    sol++;
                }
            }
        }
        return sol;
        
    }
    void fn(char [][]grid,int [][]vist,int n,int m){
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(n,m));
        vist[n][m]=1;
        int dirt[][]={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            Pair p=q.remove();
            int idn=p.idn;
            int idm=p.idm;
            for(int i=0;i<dirt.length;i++){
                int putN=idn+dirt[i][0];
                int putM=idm+dirt[i][1];
                if(putN>=0 && putM>=0 && putN<grid.length && putM<grid[0].length && vist[putN][putM]==0 && grid[putN][putM]=='1'){
                    q.add(new Pair(putN,putM));
                    vist[putN][putM]=1;
                    
                }
            }
        }
    }
}
class Pair{
    int idn;
    int idm;
    Pair(int n,int m){
        this.idn=n;
        this.idm=m;
    }
}