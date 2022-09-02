class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int value=0;
        int prvArr[]=new int[n];
        int nArr[]=new int[n];
        for(int i=0;i<n;i++){
            value+=nums[i];
            prvArr[i]=value;
        }
        value=0;
        for(int i=n-1;i>=0;i--){
            value+=nums[i];
            nArr[i]=value;
        }
        for(int i=0;i<n;i++){
            if(prvArr[i]==nArr[i]){
                return i;
            }
        }
        return -1;
        
    }
}