class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null && grid.length==0){
            return -1;
        }
        int n=grid.length;
        int m=grid[0].length;
        int tot=0;
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    tot++;
                }
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        int id_I[]={0,0,-1,1};
        int id_j[]={1,-1,0,0};
        int count=0;
        int time=0;
        while(!q.isEmpty()){
            int k=q.size();
            count=count+k;
            for(int i=0;i<k;i++){
                Pair p=q.remove();
                int id_n=p.n;
                int id_m=p.m;
                for(int j=0;j<4;j++){
                    int n_id=id_n+id_I[j];
                    int m_id=id_m+id_j[j];
                    if(n_id<0 ||n_id>=n ||m_id<0 ||m_id>=m ||grid[n_id][m_id]!=1){
                        continue;
                    }
                    grid[n_id][m_id]=2;
                    q.add(new Pair(n_id,m_id));
                }
            }
            if(q.size()>0){
                time++;
            }
        }
        if(count==tot){
            return time;
        }
        return -1;
        
    }
}
class Pair{
    int n;
    int m;
    Pair(int n1,int m1){
        this.n=n1;
        this.m=m1;
    }
}