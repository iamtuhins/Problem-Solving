class Solution {
    public int uniquePaths(int m, int n) { 
        int num[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                num[i][j]=-1;
            }
        }
        int sol=fn(num,0,0,m,n);
        return sol;
    }
    int fn(int num[][],int n,int m,int n1,int m1){
        if(n>=n1 || m>=m1){
            return 0;
        }
        if(num[n][m]>-1){
            return num[n][m];
        }
        if(n==n1-1 && m==m1-1){
            return 1;
        }
        int nm1=fn(num,n+1,m,n1,m1);
        int nm2=fn(num,n,m+1,n1,m1);
        num[n][m]=nm1+nm2;
        return nm1+nm2;
        
    }
}