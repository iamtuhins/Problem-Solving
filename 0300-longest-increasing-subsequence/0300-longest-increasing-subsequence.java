class Solution {
    public int lengthOfLIS(int[] nums) {
        int prevId=-1;
        int currId=0;
        int m=nums.length;
        int mp[][]=new int[m+1][m+1];
        for(int i=0;i<m;i++){
            Arrays.fill(mp[i],-1);
        }
        int n=fn(nums,m,prevId,currId,mp);
        return n;
        
    }
    int fn(int arr[],int n,int prevId,int currId,int [][]mp){
        if(currId>=n){
            return 0;
        }
        if(mp[prevId+1][currId]!=-1){
            return mp[prevId+1][currId];
        }
        int adding=0;
        int notAdding=0;
        if(prevId==-1 || arr[currId]>arr[prevId]){
            adding=1+fn(arr,n,currId,currId+1,mp);
        }
        notAdding=0+fn(arr,n,prevId,currId+1,mp);
        int temp=Math.max(adding,notAdding);
        mp[prevId+1][currId]=temp;
        return temp;
    }
}