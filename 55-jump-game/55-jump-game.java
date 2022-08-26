class Solution {
    public boolean canJump(int[] nums) {
        int arr[]=new int[nums.length];
        return fn(nums,0,arr);
        
    }
    boolean fn(int []nums,int id,int[] dp){
        if(id==nums.length-1){
            return true;
        }
        if(nums[id]==0){
            dp[id]=-1;
            return false;
        }
        for(int i=1;i<=nums[id];i++){
            if((id+i)<nums.length){
                if(dp[id+i]==-1){
                    continue;
                }else{
                    boolean temp=fn(nums,id+i,dp);
                    if(temp==true){
                        return true;
                    }else{
                        dp[id+i]=-1;
                    }
                }
            }else{
                break;
            }
        }
        dp[id]=-1;
        return false;
    }
    
}