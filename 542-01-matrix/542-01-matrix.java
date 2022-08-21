class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int dirt[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int vist[][]=new int[n][m];
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                Pair p=q.remove();
                int nowRow=p.n;
                int nowColm=p.m;
                int nums=p.num;
                mat[nowRow][nowColm]=nums;
                for(int j=0;j<4;j++){
                    int putRow=nowRow+dirt[j][0];
                    int putColm=nowColm+dirt[j][1];
                    if(putRow>=0 && putColm>=0 && putRow<n && putColm<m && mat[putRow][putColm]==1 && vist[putRow][putColm]==0){
                        q.add(new Pair(putRow,putColm,nums+1));
                        vist[putRow][putColm]=1;
                    }
                }
            }
        }
        return mat;
        
    }
}
class Pair{
    int n;
    int m;
    int num;
    Pair(int n,int m,int num){
        this.n=n;
        this.m=m;
        this.num=num;
    }
}