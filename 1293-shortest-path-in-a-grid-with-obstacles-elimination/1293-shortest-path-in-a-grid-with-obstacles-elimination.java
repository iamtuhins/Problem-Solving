class Solution {
    public int shortestPath(int[][] grid, int k) {
        if(grid.length==1 && grid[0].length==1)
            return 0;
        int n=grid.length;
        int m=grid[0].length;
        int nums[][]=new int[n][m];
        for(int row[]: nums)
            Arrays.fill(row,-1);
        Node temp=new Node(0,0,k);
        nums[0][0]=k;
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(0,0,k));
        int sol=0;
        int direct[][]={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                Node currNode=q.remove();
                int curRow=currNode.row;
                int curColm=currNode.colm;
                for(int j=0;j<4;j++){
                    int putRow=curRow+direct[j][0];
                    int putColm=curColm+direct[j][1];
                    if(putRow==n-1 && putColm==m-1)
                        return sol+1;
                    if(putRow>=0 && putColm>=0 && putRow<n && putColm<m){
                        if(grid[putRow][putColm]==1 && currNode.sup>0 && nums[putRow][putColm]<currNode.sup-1){
                            q.add(new Node(putRow,putColm,currNode.sup-1));
                            nums[putRow][putColm]=currNode.sup-1;
                        }else if(grid[putRow][putColm]==0 && currNode.sup>nums[putRow][putColm]){
                            q.add(new Node(putRow,putColm,currNode.sup));
                            nums[putRow][putColm]=currNode.sup;
                        }
                    }
                }
            }
            sol++;
        }
        return -1;
        
    }
}
class Node{
    int row;
    int colm;
    int sup;
    Node(int n,int m,int j){
        this.row=n;
        this.colm=m;
        this.sup=j;
    }
}