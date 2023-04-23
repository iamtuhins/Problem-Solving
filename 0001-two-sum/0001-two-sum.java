class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>mp=new HashMap<>();
        int sol[]=new int[2];
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(target-nums[i])){
                sol[0]=mp.get(target-nums[i]);
                sol[1]=i;
                return sol;
            }else{
                mp.put(nums[i],i);
            }
        }
        return sol;
        
    }
}