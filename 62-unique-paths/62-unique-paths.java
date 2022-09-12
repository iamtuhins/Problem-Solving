class Solution {
    public int uniquePaths(int m, int n) {
        int map[][]=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                map[i][j]=-1;
        int sol=fn(0,0,m-1,n-1,map);
        return sol;
        
    }
    int fn(int idN,int idM,int n,int m,int nums[][]){
        if(idN>n || idM>m){
            return 0;
        }
        if(idN==n && idM==m){
            return 1;
        }
        if(nums[idN][idM]!=-1){
            return nums[idN][idM];
        }
        int sol=fn(idN+1,idM,n,m,nums)+fn(idN,idM+1,n,m,nums);
        nums[idN][idM]=sol;
        return sol;
    }
}