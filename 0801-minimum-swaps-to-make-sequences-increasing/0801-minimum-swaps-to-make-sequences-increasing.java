class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int dp[][]=new int[m+1][2];
        int arr1[]=new int[m+1];
        int arr2[]=new int[m+1];
        for(int i=1;i<arr1.length;i++){
            arr1[i]=nums1[i-1];
            arr2[i]=nums2[i-1];
        }
        arr1[0]=-1;
        arr2[0]=-1;
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int n=fn(arr1,arr2,1,0,dp);
        return n;
    }
    int fn(int arr1[], int []arr2, int idn,int swapp,int [][]dp){
        if(idn>=arr1.length){
            return 0;
        }
        if(dp[idn][swapp]!=-1){
            return dp[idn][swapp];
        }
        int min=Integer.MAX_VALUE;
        int prv1=arr1[idn-1];
        int prv2=arr2[idn-1];
        if(swapp==1){
            int temp=prv1;
            prv1=prv2;
            prv2=temp;
        }
        if(arr1[idn]>prv1 && arr2[idn]>prv2){
            min=fn(arr1,arr2,idn+1,0,dp);
        }
        if(arr1[idn]>prv2 && arr2[idn]>prv1){
            min=Math.min(min,1+fn(arr1,arr2,idn+1,1,dp));
        }
        dp[idn][swapp]=min;
        return dp[idn][swapp];
        
    }
}