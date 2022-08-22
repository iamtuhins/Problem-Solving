class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1)
            return true;
        if(n<=0)
            return false;
        int nums=4;
        while(n%nums==0){
            if(nums==n)
                return true;
            nums=nums*4;
        }
        return false;
        
    }
}