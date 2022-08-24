class Solution {
    public int totalMoney(int n) {
        if(n==1){
            return 1;
        }
        int m=0;
        int wk=0;
        int nums=0;
        int sol=0;
        for(int i=1;i<n;i++){
            for(int j=i;j<i+7;j++){
                sol=sol+j;
                wk++;
                if(wk==n){
                    break;
                }
            }
            if(wk==n){
                break;
            }
        }
        return sol;
        
    }
}