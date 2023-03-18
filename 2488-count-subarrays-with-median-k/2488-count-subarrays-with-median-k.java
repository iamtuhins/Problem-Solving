class Solution {
    public int countSubarrays(int[] nums, int k) {
        int val=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==k){
                val=i;
                break;
            }
        }
        Map<Integer,Integer>mp=new HashMap<>();
        int diff=0;
        for(int i=val;i<nums.length;i++){
            if(nums[i]>k){
                diff++;
            }else if(nums[i]<k){
                diff--;
            }
            mp.put(diff,mp.getOrDefault(diff,0)+1);
        }
        diff=0;
        int m=0;
        for(int i=val;i>=0;i--){
            if(nums[i]>k){
                diff++;
            }else if(nums[i]<k){
                diff--;
            }
            m+=mp.getOrDefault(0-diff,0);
            m+=mp.getOrDefault(1-diff,0);
        }
        return m;
        
    }
}