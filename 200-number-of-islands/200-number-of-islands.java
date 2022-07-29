class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int sol=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    fn(grid,i,j);
                    sol++;
                }
            }
        }
        return sol;
        
        
    }
    void fn(char grid[][],int i,int j){
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            int sz=q.size();
            for(int m=0;m<sz;m++){
                Pair p=q.remove();
                int num1=p.num1;
                int num2=p.num2;
                if(isVald(grid,num1,num2)){
                    grid[num1][num2]='0';
                q.add(new Pair(num1+1,num2));
                q.add(new Pair(num1,num2+1));
                q.add(new Pair(num1-1,num2));
                q.add(new Pair(num1,num2-1));
                }
            }
        }
    }
    boolean isVald(char grid[][],int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
            return false;
        }
        return true;
    }
}
class Pair{
    int num1;
    int num2;
    Pair(int n,int m){
        this.num1=n;
        this.num2=m;
    }
}