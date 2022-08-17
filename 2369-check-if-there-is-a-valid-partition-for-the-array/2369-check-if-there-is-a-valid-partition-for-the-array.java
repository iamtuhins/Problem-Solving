class Solution {
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        int map[]=new int[n];
        for(int i=0;i<n;i++){
            map[i]=-1;
        }
        boolean sol;
        sol=fn(nums,0,map);
        return sol;
        
        
    }
    boolean fn(int nums[],int id,int[]map){
        if(id>=nums.length)
            return true;
        if(map[id]>-1){
            if(map[id]==1)
                return true;
            else
                return false;
        }
        boolean fp=false;
        boolean sp=false;
        boolean tp=false;
        if(nums.length>id+1 && nums[id]==nums[id+1]){
            fp=fn(nums,id+2,map);
        }
        if(nums.length>id+2 && nums[id]==nums[id+1] && nums[id+1]==nums[id+2]){
            sp=fn(nums,id+3,map);
        }
        if(nums.length>id+2 && (nums[id]==nums[id+1]-1) && (nums[id+1]==nums[id+2]-1)){
            tp=fn(nums,id+3,map);
        }
        if(fp || sp || tp){
            map[id]=1;
            return true;
        }
        map[id]=0;
        return false;
    }
}