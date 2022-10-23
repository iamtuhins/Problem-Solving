class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int sol[]=new int[2];
        Set<Integer>st=new HashSet<>();
        for(int i=0;i<n;i++){
            boolean temp=st.add(nums[i]);
            if(temp==false){
                sol[0]=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(!st.contains(i+1)){
                sol[1]=i+1;
                break;
            }
        }
        return sol;
        
    }
}