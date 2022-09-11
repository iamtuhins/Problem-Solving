class Solution {
    public int climbStairs(int n) {
        int map[]=new int[n+1];
        Arrays.fill(map,-1);
        int sol=fn(n,0,map);
        return sol;
        
        
    }
    int fn(int n,int nums,int[]map){
        if(nums>n){
            return 0;
        }
        if(n==nums){
            return 1;
        }
        if(map[nums]!=-1){
            return map[nums];
        }
        map[nums]=fn(n,nums+1,map)+fn(n,nums+2,map);
        return map[nums];
    }
}