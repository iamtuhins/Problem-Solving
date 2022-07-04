class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n<=1){
            return n;
        }
        Boolean sign=null;
        int sol=n;
        for(int i=0;i<n-1;i++){
            int temp=nums[i+1]-nums[i];
            if(temp==0){
                sol--;
            }else if(sign==null){
                sign=temp>0;
            }else if((temp > 0 && sign) || (temp < 0 && !sign)){
                sol--;
            }else{
                sign=!sign;
            }
        }
        return sol;
        
    }
}