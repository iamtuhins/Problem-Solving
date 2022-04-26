class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int largestSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            if(largestSum<sum){
                largestSum=sum;
            }
            if(sum<0){
                sum=0;
            }
            
        }
        return largestSum;
        
    }
}