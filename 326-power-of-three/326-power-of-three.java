class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        int nums=3;
        while(n%nums==0){
            if(nums==n){
                return true;
            }
            if(nums>n){
                break;
            }
            nums=nums*3;
        }
        return false;
        
    }
}