class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int temp=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=temp){
                return temp;
            }
            temp++;
        }
        return n;
    }
}