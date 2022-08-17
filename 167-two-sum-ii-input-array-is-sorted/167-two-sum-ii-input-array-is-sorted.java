class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int sol[]=new int[2];
        for(int i=0;i<numbers.length-1;i++){
            int nums=target-numbers[i];
            int val=find(numbers,i+1,nums,numbers.length-1);
            if(val>-1){
                sol[1]=val+1;
                sol[0]=i+1;
                return sol;
            }
        }
        return sol;
        
    }
    int find(int nums[],int st,int m,int en){
        while(st<=en){
            int pvt=(st+en)/2;
            if(nums[pvt]==m){
                return pvt;
            }else if(nums[pvt]>m){
                en=pvt-1;
            }else{
                st=pvt+1;
            }
        }
        return -1;
    }
}