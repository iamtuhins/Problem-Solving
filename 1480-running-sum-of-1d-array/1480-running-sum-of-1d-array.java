class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int m=0;
        int temp[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            m=m+nums[i];
            temp[i]=m;
        }
        return temp;
        
    }
}