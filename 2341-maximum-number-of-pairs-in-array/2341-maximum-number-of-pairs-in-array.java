class Solution {
    public int[] numberOfPairs(int[] nums) {
        int n=nums.length;
        Set<Integer>st=new HashSet<>();
        int pair=0;
        for(int i=0;i<n;i++){
            if(st.contains(nums[i])){
                pair++;
                st.remove(nums[i]);
            }else{
                st.add(nums[i]);
            }
        }
        int sol[]=new int[2];
        sol[0]=pair;
        sol[1]=st.size();
        return sol;
        
    }
}