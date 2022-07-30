class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        int nums[][]={{-1,0},{0,-1},{1,0},{0,1}};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int n1=p.n;
            int m1=p.m;
            for(int i=0;i<4;i++){
                int id1=n1+nums[i][0];
                int id2=m1+nums[i][1];
                if(id1<0 || id2<0 || id1>=n || id2>=m ||mat[id1][id2]!=-1){
                    continue;
                }
                mat[id1][id2]=mat[n1][m1]+1;
                q.add(new Pair(id1,id2));
            }
        }
        return mat;
    }
}
class Pair{
    int n;
    int m;
    Pair(int n,int m){
        this.n=n;
        this.m=m;
    }
}