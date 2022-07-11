class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vist[][]=new boolean[n][m];
        int sol=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vist[i][j]==false && grid[i][j]=='1'){
                    fn(grid,vist,i,j);
                    sol=sol+1;
                }
            }
        }
        return sol;
    }
    void fn(char grid[][],boolean vist[][],int n,int m){
        if(n<0|| n>=grid.length|| m<0|| m>=grid[0].length|| vist[n][m]==true|| grid[n][m]=='0'){
            return;
        }
        vist[n][m]=true;
        fn(grid,vist,n+1,m);
        fn(grid,vist,n,m+1);
        fn(grid,vist,n-1,m);
        fn(grid,vist,n,m-1);
    }
    
}