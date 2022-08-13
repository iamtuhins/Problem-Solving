class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int dist[][]={{1,0},{0,1},{-1,0},{0,-1}};
        int startValue=image[sr][sc];
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        image[sr][sc]=color;
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                Pair temp=q.remove();
                for(int j=0;j<4;j++){
                    int idn=temp.n;
                    int idm=temp.m;
                    idn=idn+dist[j][0];
                    idm=idm+dist[j][1];
                    if(idn>=0 && idm>=0 && idn<n && idm<m && image[idn][idm]==startValue && startValue!=color){
                        q.add(new Pair(idn,idm));
                        image[idn][idm]=color;
                    }
                }
            }
        }
        return image;
        
        
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