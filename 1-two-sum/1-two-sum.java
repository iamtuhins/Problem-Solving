class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int sol[]=new int[2];
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                sol[0]=map.get(temp);
                sol[1]=i;
                return sol;
            }
            map.put(nums[i],i);
        }
        return sol;
        
    }
}