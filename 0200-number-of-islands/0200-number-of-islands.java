class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vist[][]=new int[n][m];
        int sol=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vist[i][j]==0 && grid[i][j]=='1'){
                    makeIsland(grid,vist,i,j);
                    sol++;
                }
            }
        }
        return sol;
        
    }
    void makeIsland(char arr[][],int [][]vist,int n,int m){
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(n,m));
        int mp[][]={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int num1=p.n1;
            int num2=p.m1;
            vist[num1][num2]=1;
            for(int i=0;i<4;i++){
                int t1=num1+mp[i][0];
                int t2=num2+mp[i][1];
                if(t1>=0 && t1<arr.length && t2>=0 && t2<arr[0].length){
                    if(arr[t1][t2]=='1' && vist[t1][t2]==0){
                        q.add(new Pair(t1,t2));
                        vist[t1][t2]=1;
                    }
                }
            }
            
        }
            
    }
}
class Pair{
    int n1;
    int m1;
    Pair(int n,int m){
        this.n1=n;
        this.m1=m;
    }
}