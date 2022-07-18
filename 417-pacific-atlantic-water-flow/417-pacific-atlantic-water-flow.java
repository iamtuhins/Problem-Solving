class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        boolean pecefic[][]=new boolean[n][m];
        boolean atln[][]=new boolean[n][m];
        for(int i=0;i<m;i++){
            fn(pecefic,0,i,heights,heights[0][i]);
            fn(atln,n-1,i,heights,heights[n-1][i]);
        }
        for(int i=0;i<n;i++){
            fn(pecefic,i,0,heights,heights[i][0]);
            fn(atln,i,m-1,heights,heights[i][m-1]);
        }
        List<List<Integer>>sol=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pecefic[i][j]==true && atln[i][j]==true){
                    List<Integer>temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    sol.add(new ArrayList<>(temp));
                }
            }
        }
        return sol;
        
    }
    void fn(boolean [][]arr,int i,int j,int heights[][],int prev){
        if(i<0 ||j<0 ||i>=heights.length ||j>=heights[0].length ||arr[i][j]==true|prev>heights[i][j]){
            return;
        }
        arr[i][j]=true;
        fn(arr,i+1,j,heights,heights[i][j]);
        fn(arr,i,j+1,heights,heights[i][j]);
        fn(arr,i-1,j,heights,heights[i][j]);
        fn(arr,i,j-1,heights,heights[i][j]);
    }
}