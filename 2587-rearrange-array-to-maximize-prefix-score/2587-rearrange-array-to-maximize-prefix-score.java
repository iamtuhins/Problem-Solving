class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long arr[]=new long[nums.length];
        long temp=0;
        int m=0;
        int n=nums.length;
        for(int i=0;i<arr.length;i++){
            temp+=nums[(n-1)-i];
            arr[i]=temp;
            if(arr[i]>0){
                m++;
            }
        }
        return m;
        
        
    }
}