class Solution {
    public int climbStairs(int n) {
        int []nums=new int[n+1];
        int m=0;
        int sol=fn(n,nums,m);
        return sol;
        
        
        
    }
    int fn(int n,int nums[],int idn){
        if(idn>n){
            return 0;
        }
        if(nums[idn]>0){
            return nums[idn];
        }
        if(idn==n){
            return 1;
        }
        int lf=fn(n,nums,idn+1);
        int rt=fn(n,nums,idn+2);
        nums[idn]=lf+rt;
        return lf+rt;
    }
}