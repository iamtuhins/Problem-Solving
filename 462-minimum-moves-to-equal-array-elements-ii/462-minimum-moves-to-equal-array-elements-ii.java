class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int fs=0;
        int sn=0;
        if(n%2==0){
            int m=n/2;
            for(int i=0;i<m;i++){
                fs=fs+nums[i];
            }
            for(int i=m;i<n;i++){
                sn=sn+nums[i];
            }
        }else{
            int m=n/2;
            for(int i=0;i<m;i++){
                fs=fs+nums[i];
            }
            for(int i=m+1;i<n;i++){
                sn=sn+nums[i];
            }
        }
        int sol=sn-fs;
        return sol;
        
    }
}