class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        int sol[]=new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                int n=map.get(target-nums[i]);
                int m=i;
                sol[0]=n;
                sol[1]=m;
                return sol;
            }
            map.put(nums[i],i);
        }
        return sol;
    }
}