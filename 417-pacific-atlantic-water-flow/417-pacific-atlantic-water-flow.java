class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        List<List<Integer>>sol=new ArrayList<>();
        Set<List<Integer>>po=new HashSet<>();
        Set<List<Integer>>ao=new HashSet<>();
        for(int j=0;j<m;j++){
            dfs(heights,po,0,j,heights[0][j]);
            dfs(heights,ao,n-1,j,heights[n-1][j]);
        }
        for(int i=0;i<n;i++){
            dfs(heights,po,i,0,heights[i][0]);
            dfs(heights,ao,i,m-1,heights[i][m-1]);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                List<Integer>temp=new ArrayList<>();
                temp.add(i);
                temp.add(j);
                if(po.contains(temp) && ao.contains(temp)){
                    sol.add(temp);
                }
            }
        }
        return sol;
        
    }
    void dfs(int [][]ht,Set<List<Integer>>vist,int i,int j,int prev){
        List<Integer>ls=new ArrayList<>();
        ls.add(i);
        ls.add(j);
        if(i<0 ||j<0 ||i>=ht.length ||j>=ht[0].length||vist.contains(ls) ||prev>ht[i][j]){
            return;
        }
        vist.add(ls);
        dfs(ht,vist,i-1,j,ht[i][j]);
        dfs(ht,vist,i,j-1,ht[i][j]);
        dfs(ht,vist,i+1,j,ht[i][j]);
        dfs(ht,vist,i,j+1,ht[i][j]);
    }
}