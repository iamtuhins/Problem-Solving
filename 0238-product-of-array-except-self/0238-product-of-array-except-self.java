class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        int temp=1;
        for(int i=0;i<n;i++){
            temp=temp*nums[i];
            prefix[i]=temp;
        }
        temp=1;
        for(int i=n-1;i>=0;i--){
            temp=temp*nums[i];
            suffix[i]=temp;
        }
        int sol[]=new int[n];
        for(int i=0;i<n;i++){
            if(i==0){
                sol[i]=suffix[i+1];
            }else if(i==n-1){
                sol[i]=prefix[n-2];
            }else{
                sol[i]=prefix[i-1]*suffix[i+1];
            }
        }
        return sol;
        
        
    }
}