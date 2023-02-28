class Solution {
    public int[] divisibilityArray(String word, int m) {
        int sol[]=new int[word.length()];
        int n=word.length();
        long nums=0;
        for(int i=0;i<n;i++){
            long val=Character.getNumericValue(word.charAt(i));
            long temp=fn(val,nums);
            nums=temp;
            if(temp%m==0){
                sol[i]=1;
            }else{
                sol[i]=0;
            }
            nums%=m;
            
        }
        return sol;
        
    }
    long fn(long val,long nums){
        long temp=(nums*10)+val;
        return temp;
    }
}