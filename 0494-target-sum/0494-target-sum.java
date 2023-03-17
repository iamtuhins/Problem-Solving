class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int m=fn(nums,0,target);
        return m;
    }
    int fn(int []arr,int id,int target){
        if(id>=arr.length){
            if(target==0){
                return 1;
            }
            return 0;
        }
        int nums=arr[id]*-1;
        int getting=fn(arr,id+1,target-(nums));
        int notGetting=fn(arr,id+1,target-arr[id]);
        int temp=getting+notGetting;
        return temp;
    }
}