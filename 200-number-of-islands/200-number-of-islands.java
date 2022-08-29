class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int sol=0;
        int m=grid[0].length;
        int vist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vist[i][j]==0){
                    fn(grid,vist,i,j);
                    sol++;
                }
            }
            
        }
        return sol;
        
    }
    void fn(char grid[][],int vist[][],int n,int m){
        Queue<Pair>q=new LinkedList<>();
        int dirt[][]={{0,1},{1,0},{0,-1},{-1,0}};
        q.add(new Pair(n,m));
        vist[n][m]=1;
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                Pair temp=q.remove();
                int idn=temp.n;
                int idm=temp.m;
                for(int j=0;j<4;j++){
                    int putN=idn+dirt[j][0];
                    int putM=idm+dirt[j][1];
                    if(putN>=0 && putM>=0 && putN<grid.length && putM<grid[0].length){
                        if(vist[putN][putM]==0 && grid[putN][putM]=='1'){
                            q.add(new Pair(putN,putM));
                            vist[putN][putM]=1;
                        }
                    }
                }
            }
        }
    }
}
class Pair{
    int n;
    int m;
    Pair(int n,int m){
        this.n=n;
        this.m=m;
    }
}