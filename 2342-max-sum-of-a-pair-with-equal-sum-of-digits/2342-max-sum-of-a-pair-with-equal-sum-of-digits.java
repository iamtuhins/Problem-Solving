class Solution {
    public int maximumSum(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>mp=new HashMap<>();
        int sol=0;
        for(int i=0;i<n;i++){
            int num1=fn(nums[i]);
            System.out.println(num1);
            if(!mp.containsKey(num1)){
                mp.put(num1,nums[i]);
            }else{
                sol=Math.max(sol,mp.get(num1)+nums[i]);
                int temp=Math.max(mp.get(num1),nums[i]);
                mp.put(num1,temp);
            }
        }
        if(sol>0){
            return sol;
        }
        return -1;
        
    }
    int fn(int num){
        int sm=0;
        while(num>0){
            int temp=num%10;
            sm=sm+temp;
            num=num/10;
        }
        return sm;
    }
}