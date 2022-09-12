class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int map[]=new int[cost.length];
        Arrays.fill(map,-1);
        int numZ=fn(cost,0,map);
        int numN=fn(cost,1,map);
        int sol=Math.min(numZ,numN);
        return sol;
        
        
    }
    int fn(int []cost,int id,int []map){
        if(id>=cost.length){
            return 0;
        }
        if(map[id]!=-1){
            return map[id];
        }
       int min=cost[id]+Math.min(fn(cost,id+1,map),
        fn(cost,id+2,map));
        map[id]=min;
        return min;
    }
}