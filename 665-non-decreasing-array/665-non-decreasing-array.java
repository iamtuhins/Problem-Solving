class Solution {
    public boolean checkPossibility(int[] nums) {
        int n=nums.length;
        boolean fl=false;
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i] && fl==false){
                if(i>=2 && nums[i-2]>nums[i]){
                    nums[i]=nums[i-1];
                }else{
                    nums[i-1]=nums[i];
                }
                fl=true;
                
            }else if(nums[i-1]>nums[i] && fl==true){
                return false;
            }
        }
        return true;
        
    }
}