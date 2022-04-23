class Solution {
    public void sortColors(int[] nums) {
        int lft=0;
        int mid=0;
        int ryt=nums.length-1;
       while(mid<=ryt){
           if(nums[mid]==0){
               int temp=nums[mid];
               nums[mid]=nums[lft];
               nums[lft]=temp;
               mid++;
               lft++;
           }else if(nums[mid]==2){
               int temp=nums[mid];
               nums[mid]=nums[ryt];
               nums[ryt]=temp;
               ryt--;
           }else{
               mid++;
           }
       }
        
        
    }
}