class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int arr[][]=new int[n+1][amount+1];
        int sol=fn(arr,coins,n+1,amount+1);
        if(sol>=Integer.MAX_VALUE-1){
            return -1;
        }
        return sol;
    }
    int fn(int arr[][],int coins[],int n,int m){
        int temp=Integer.MAX_VALUE-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    arr[i][j]=temp;
                }
                if(j==0){
                    arr[i][j]=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(coins[i-1]<=j){
                    arr[i][j]=Math.min(1+arr[i][j-coins[i-1]],arr[i-1][j]);
                }else{
                    arr[i][j]=arr[i-1][j];
                }
            }
        }
        return arr[n-1][m-1];
    }
}