class Solution {
    public int search(int[] nums, int target) {
        int sol=fn(nums,target);
        return sol;
        
        
    }
    int fn(int nums[],int target){
        int idn=0;
        int idm=nums.length-1;
        while(idn<=idm){
            int pivot=(idn+idm)/2;
            if(nums[pivot]==target){
                return pivot;
            }else if(nums[pivot]>target){
                idm=pivot-1;
            }else{
                idn=pivot+1;
            }
        }
        return -1;
    }
}