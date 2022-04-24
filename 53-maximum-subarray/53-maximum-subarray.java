class Solution {
    public int maxSubArray(int[] nums) {
        int largestSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(sum>largestSum){
                largestSum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return largestSum;
        
    }
}