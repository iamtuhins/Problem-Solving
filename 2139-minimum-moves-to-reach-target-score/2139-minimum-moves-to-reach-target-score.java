class Solution {
    public int minMoves(int target, int maxDoubles) {
        int n=0;
        while(maxDoubles>0 && target!=1){
            if(target%2==0 && target/2>=1){
                target=target/2;
                n++;
                maxDoubles--;
            }else if(target%2!=0 && target-1>=1){
                target--;
                n++;
            }
        }
        if(target!=1){
            int temp=target-1;
            n=n+temp;
        }
        return n;
        
    }
}