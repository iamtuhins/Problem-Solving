class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vist[][]=new boolean[n][m];
        int sol=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vist[i][j]==false){
                    fn(grid,i,j,vist);
                    sol++;
                }
            }
        }
        return sol;
        
    }
    void fn(char grid[][],int i,int j,boolean vist[][]){
        if(i<0 ||j<0 ||i>=grid.length ||j>=grid[0].length ||grid[i][j]=='0' ||vist[i][j]==true){
            return;
        }
        vist[i][j]=true;
        fn(grid,i+1,j,vist);
        fn(grid,i-1,j,vist);
        fn(grid,i,j+1,vist);
        fn(grid,i,j-1,vist);
    }
}