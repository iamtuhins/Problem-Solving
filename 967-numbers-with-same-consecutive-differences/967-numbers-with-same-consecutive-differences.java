class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer>lst=new ArrayList<>();
        for(int i=1;i<10;i++){
            fn(i,1,n,k,i,lst);
        }
        int sol[]=new int[lst.size()];
        for(int i=0;i<sol.length;i++){
            sol[i]=lst.get(i);
        }
        return sol;
        
    }
    void fn(int digit,int nums,int n,int k,int prev,List<Integer>lst){
        if(nums==n){
            lst.add(digit);
            return;
        }
        int next=prev+k;
        if(next<=9){
            fn((digit*10)+next,nums+1,n,k,next,lst);
        }
        next=prev-k;
        if(k!=0 && next>=0){
            fn((digit*10)+next,nums+1,n,k,next,lst);
        }
        
    }
}