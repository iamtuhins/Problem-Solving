class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            StringBuilder st=new StringBuilder();
            for(int j=0;j<m;j++){
                st.append(grid[i][j]);
                st.append(" ");
            }
            String temp=st.toString();
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        int sol=0;
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<m;j++){
                sb.append(grid[j][i]);
                sb.append(" ");
            }
            String temp=sb.toString();
            if(map.containsKey(temp)){
                sol=sol+map.get(temp);
            }
        }
        return sol;
        
        
    }
}