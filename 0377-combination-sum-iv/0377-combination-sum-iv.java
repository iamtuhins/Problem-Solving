class Solution {
    public int combinationSum4(int[] nums, int target) {
        int map[]=new int[target+1];
        Arrays.fill(map,-1);
        int m=fn(target,nums,map);
        return m;
        
    }
    int fn(int target,int arr[],int []map){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(map[target]!=-1){
            return map[target];
        }
        int temp=0;
        for(int i=0;i<arr.length;i++){
            target-=arr[i];
            temp=temp+fn(target,arr,map);
            target+=arr[i];
        }
        map[target]=temp;
        return temp;
    }
}