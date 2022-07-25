class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int n1=ryt(nums,target);
        int n2=lft(nums,target);
        int sol[]=new int[2];
        sol[0]=n2;
        sol[1]=n1;
        return sol;
    }
    int lft(int []nums,int t){
        int lf=0;
        int rt=nums.length-1;
        int sol=-1;
        while(rt>=lf){
            int pivot=(lf+rt)/2;
            if(nums[pivot]==t){
                sol=pivot;
                rt=pivot-1;
            }else if(nums[pivot]>t){
                rt=pivot-1;
            }else{
                lf=pivot+1;
            }
        }
        return sol;
    }
    int ryt(int []nums,int t){
        int lf=0;
        int rt=nums.length-1;
        int sol=-1;
        while(rt>=lf){
            int pivot=(lf+rt)/2;
            if(nums[pivot]==t){
                sol=pivot;
                lf=pivot+1;
            }else if(nums[pivot]>t){
                rt=pivot-1;
            }else{
                lf=pivot+1;
            }
        }
        return sol;
    }
}