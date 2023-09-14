class Solution {
    public int minPathSum(int[][] grid) {
        int ln=grid.length;
        int lm=grid[0].length;
        long mp[][]=new long[ln+1][lm+1];
        for(int i=0;i<mp.length;i++){
            Arrays.fill(mp[i],-1);
        }
        long m=fn(grid,0,0,mp);
        return (int)m;
        
        
        
    }
 long fn(int [][]grid,int idN, int idM,long [][]mp){
        if(idN<0 || idN>=grid.length || idM<0 || idM>=grid[0].length){
            return Integer.MAX_VALUE;
        }
     if(mp[idN][idM]!=-1){
         return mp[idN][idM];
     }
     if(idN==grid.length-1 && idM==grid[0].length-1){
        return grid[idN][idM];
     }
     long lft=grid[idN][idM]+fn(grid,idN+1,idM,mp);
     long rght=grid[idN][idM]+fn(grid,idN,idM+1,mp);
     long m=Math.min(lft,rght);
     mp[idN][idM]=m;
     return m;
    }
}