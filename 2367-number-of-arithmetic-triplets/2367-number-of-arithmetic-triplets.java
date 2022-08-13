class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int sol=0;
        Set<Integer>st=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(st.contains(nums[i]-diff) && st.contains(nums[i]-(diff*2))){
                sol++;
            }
            st.add(nums[i]);
        }
        return sol;
        
    }
}