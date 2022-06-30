class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vist[][]=new boolean[n][m];
        int sol=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vist[i][j]==false){
                    drawTree(i,j,vist,grid);
                    sol++;
                }
            }
        }
        return sol;
        
    }
    void drawTree(int i,int j,boolean vist[][],char grid[][]){
        if(i<0 || i>=grid.length ||j<0 || 
           j>=grid[0].length || grid[i][j]=='0' || vist[i][j]==true){
           return; 
        }
        vist[i][j]=true;
        drawTree(i+1,j,vist,grid);
        drawTree(i,j+1,vist,grid);
        drawTree(i-1,j,vist,grid);
        drawTree(i,j-1,vist,grid);
    }
}