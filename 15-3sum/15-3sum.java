class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>>sol=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int fe=i;
            int se=i+1;
            int te=n-1;
            while(se<te){
                int temp=nums[fe]+nums[se]+nums[te];
                if(temp==0){
                    List<Integer>ls=new ArrayList<>();
                    ls.add(nums[fe]);
                    ls.add(nums[se]);
                    ls.add(nums[te]);
                    sol.add(new ArrayList<Integer>(ls));
                    se++;
                    while(nums[se]==nums[se-1] && se<te){
                        se++;
                    }
                }else if(temp>0){
                    te--;
                }else{
                    se++;
                }
            }
            
        }
        return sol;
        
    }
}