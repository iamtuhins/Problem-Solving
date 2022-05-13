class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>>sol=new ArrayList<>();
        List<Integer>out=new ArrayList<>();
        fn(sol,nums,out);
        return sol;
        
        
    }
    void fn(List<List<Integer>>sol,int nums[],List<Integer>out){
        if(out.size()>=nums.length){ 
            //if one permutation is ready make a copy of that and stored it.
            sol.add(new ArrayList<>(out));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //elements should be put one time for each permutation
            if(!out.contains(nums[i])){
                out.add(nums[i]);
                fn(sol,nums,out);
                //after completing the method when it return need to remove the
                // element that is added using backtracking here.
                out.remove(out.size()-1);
            }
        }
    }
}