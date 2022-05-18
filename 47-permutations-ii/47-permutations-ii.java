class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n=nums.length;
        List<Integer>out=new ArrayList<>();
        List<Integer>num=new ArrayList<>();
        List<List<Integer>>sol=new ArrayList<>();
        fn(sol,out,num,nums);
        return sol;
        
        
    }
    void fn(List<List<Integer>>sol,List<Integer>out,List<Integer>num,int []nums){
        if(out.size()>=nums.length){
            if(!sol.contains(out)){
                sol.add(new ArrayList<>(out));
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!num.contains(i+1)){
                num.add(i+1);
                out.add(nums[i]);
                fn(sol,out,num,nums);
                num.remove(num.size()-1);
                out.remove(out.size()-1);
            }
        }
    }
}