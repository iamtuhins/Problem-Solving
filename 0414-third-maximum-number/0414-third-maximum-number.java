class Solution {
    public int thirdMax(int[] nums) {
        int n=nums.length;
      HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        List<Integer>lst=new ArrayList<>();
        Iterator<Integer>i=set.iterator();
        while(i.hasNext()){
            lst.add(i.next());
        }
        Collections.sort(lst);
        int m=lst.size();
        if(3>m){
            return lst.get(m-1);
        }
        return lst.get(m-3);
        
    }
}