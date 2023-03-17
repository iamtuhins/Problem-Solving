class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        Map<String,Integer>dp=new HashMap<>();
        int m=fn(nums,0,target,dp);
        return m;
    }
    int fn(int []arr,int id,int target,Map<String,Integer>dp){
        if(id>=arr.length){
            if(target==0){
                return 1;
            }
            return 0;
        }
        String key=id+"-"+target;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int nums=arr[id]*-1;
        int getting=fn(arr,id+1,target-(nums),dp);
        int notGetting=fn(arr,id+1,target-arr[id],dp);
        int temp=getting+notGetting;
        dp.put(id+"-"+target,temp);
        return temp;
    }
}