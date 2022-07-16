class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vist[][]=new boolean[n][m];
        int sol=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vist[i][j]==false){
                    int num=fn(grid,i,j,vist);
                    sol=Math.max(sol,num);
                }
            }
        }
        return sol;
    }
    int fn(int [][]grid, int i,int j,boolean vist[][]){
        if(i<0 ||j<0 ||i>=grid.length ||j>=grid[0].length ||grid[i][j]==0 ||vist[i][j]==true){
            return 0;
        }
        vist[i][j]=true;
        int num1=0;
        num1=fn(grid,i+1,j,vist);
        num1=num1+fn(grid,i-1,j,vist);
        num1=num1+fn(grid,i,j+1,vist);
        num1=num1+fn(grid,i,j-1,vist);
        return 1+num1;
        
    }
}