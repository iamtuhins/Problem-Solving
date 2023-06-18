class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n=0;
        Map<Integer,Integer>dp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int temp=arr[i]-difference;
            int tempVal=0;
            if(dp.containsKey(temp)){
                 tempVal=dp.get(temp);
            }
                int val=1+tempVal;
                n=Math.max(n,val);
                dp.put(arr[i],val);
        }
        return n;
        
    }
}