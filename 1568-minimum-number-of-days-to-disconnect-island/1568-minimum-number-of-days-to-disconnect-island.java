class Solution {
    int dd[][]={{0,-1},{-1,0},{0,1},{1,0}};
    public int minDays(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(numIsland(grid)!=1){
            return 0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    if(numIsland(grid)!=1){
                        return 1;
                    }
                    grid[i][j]=1;
                }
            }
        }
        return 2;
        
    }
    int numIsland(int grid[][]){
        int num=0;
        boolean vist[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && vist[i][j]==false){
                    num++;
                    connected(grid,i,j,vist);
                }
            }
        }
        return num;
    }
    void connected(int grid[][],int i,int j,boolean vist[][]){
        vist[i][j]=true;
        for(int k=0;k<4;k++){
            int id_1=i+dd[k][0];
            int id_2=j+dd[k][1];
            if(id_1>=0 && id_2>=0 && id_1<grid.length && id_2<grid[0].length && grid[id_1][id_2]==1 && vist[id_1][id_2]==false){
                connected(grid,id_1,id_2,vist);
            }
        }
    }
}