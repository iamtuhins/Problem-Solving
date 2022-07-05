class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer>set=new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int longSeq=0;
        for(int m: nums){
            if(!set.contains(m-1)){
                int currentNum=m;
                int currentSeq=1;
                while(set.contains(currentNum+1)){
                    currentSeq=currentSeq+1;
                    currentNum++;
                }
                longSeq=Math.max(currentSeq,longSeq);
            }
        }
        return longSeq;
        
    }
}