class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        int n=nums.size();
        if(2>=n)
            return true;
        for(int i=1;i<n;i++){
            if(nums.get(i-1)+nums.get(i)>=m){
                return true;
            }
        }
        return false;
        
    }
}