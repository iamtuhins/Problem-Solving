class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<List<Integer>>sol=new ArrayList<>();
        List<Integer>out=new ArrayList<>();
        fn(sol,nums,map,out);
        return sol;
        
        
    }
    void fn(List<List<Integer>>sol,int nums[],Map<Integer,Integer>map,List<Integer>out){
        if(out.size()>=nums.length){
            sol.add(new ArrayList<>(out));
            return;
        }
        for(int i:map.keySet()){
            if(map.get(i)>0){
                out.add(i);
                map.put(i,map.get(i)-1);
                fn(sol,nums,map,out);
                out.remove(out.size()-1);
                map.put(i,map.get(i)+1);
            }
        }
    }
}