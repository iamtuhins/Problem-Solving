class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vist[][]=new int[n][m];
        int sol=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vist[i][j]==0 && grid[i][j]=='1'){
                    dfs(i,j,vist,grid);
                    sol++;
                }
            }
        }
        return sol;
        
    }
    void dfs(int i, int j,int [][]vist,char [][]grid){
        if(i<0 ||j<0 ||i>=grid.length || j>=grid[0].length||vist[i][j]==1 || grid[i][j]=='0'){
            return;
        }
        vist[i][j]=1;
        dfs(i+1,j,vist,grid);
        dfs(i,j+1,vist,grid);
        dfs(i-1,j,vist,grid);
        dfs(i,j-1,vist,grid);
    }
}