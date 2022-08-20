class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        boolean atln[][]=new boolean[n][m];
        boolean pacef[][]=new boolean[n][m];
        for(int i=0;i<m;i++){
            if(atln[0][i]==false){
                fn(heights,atln,0,i);
            }
            if(pacef[n-1][i]==false){
                fn(heights,pacef,n-1,i);
            }
        }
        for(int i=0;i<n;i++){
            if(atln[i][0]==false){
                fn(heights,atln,i,0);
            }
            if(pacef[i][m-1]==false){
                fn(heights,pacef,i,m-1);
            }
        }
        List<List<Integer>>sol=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(atln[i][j]==true && pacef[i][j]==true){
                    List<Integer>temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    sol.add(new ArrayList<Integer>(temp));
                }
            }
        }
        return sol;
        
    }
    void fn(int [][]heights,boolean arr[][],int idn,int idm){
        int dirt[][]={{0,1},{1,0},{0,-1},{-1,0}};
        arr[idn][idm]=true;
        for(int i=0;i<4;i++){
            int putRow=idn+dirt[i][0];
            int putColm=idm+dirt[i][1];
            if(putRow>=0 && putColm>=0 && putRow<heights.length && putColm<heights[0].length){
                if(arr[putRow][putColm]==false && heights[putRow][putColm]>=heights[idn][idm]){
                    fn(heights,arr,putRow,putColm);
                }
            }
        }
    }
}