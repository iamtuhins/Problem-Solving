class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Set<Integer>st=new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(nums[i]);
        }
        int sol=0;
        for(int i=0;i<n;i++){
            if(!st.contains(nums[i]-1)){
                int currentNode=nums[i];
                int currentSeq=1;
                while(st.contains(currentNode+1)){
                    currentSeq+=1;
                    currentNode+=1;
                }
                sol=Math.max(currentSeq,sol);
            }
        }
        return sol;
        
    }
}