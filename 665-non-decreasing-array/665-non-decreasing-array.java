class Solution {
    public boolean checkPossibility(int[] nums) {
        int n=nums.length;
        boolean fl=false;
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i] && fl==false){
                //if nums are large, large,large than make it large also.
                if(i>=2 && nums[i-2]>nums[i]){
                    nums[i]=nums[i-1];
                }else{
                    //if nums are small, large, small than make the large small.
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