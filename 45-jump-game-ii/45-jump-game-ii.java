class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        int value=0;
        int base=0;
        int sol=0;
        for(int i=0;i<n;i++){
            value=Math.max(i+nums[i],value);
            if(value>=n-1){
                sol++;
                break;
            }
            if(i==base){
                base=value;
                sol++;
            }
        }
        return sol;
        
    }
}