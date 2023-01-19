class Solution {
    public int combinationSum4(int[] nums, int target) {
        int map[]=new int[target+1];
        Arrays.fill(map,-1);
        int m=fn(target,nums,map);
        return m; 
        
    }
    int fn(int target,int nums[],int []map){
        if(target==0){
            return 1;
        }
        if(0>target){
            return 0;
        }
        if(map[target]!=-1){
            return map[target];
        }
        int temp=0;
        for(int i=0;i<nums.length;i++){
            target=target-nums[i];
            temp=temp+fn(target,nums,map);
            target=target+nums[i];
        }
        map[target]=temp;
        return map[target];
    }
}