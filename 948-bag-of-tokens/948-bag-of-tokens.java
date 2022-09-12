class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n=tokens.length;
        int idSell=0;
        int idBuy=n-1;
        int sol=0;
        Arrays.sort(tokens);
        while(idSell<=idBuy){
            if(tokens[idSell]>power && sol==0)
                break;
            if(tokens[idSell]<=power && tokens[idSell]!=-1){
                power-=tokens[idSell];
                sol++;
                idSell++;
            }else if(sol>0 && idSell!=idBuy){
                sol--;
                power+=tokens[idBuy];
                tokens[idBuy]=-1;
                idBuy--;
            }else{
                idSell++;
            }
        }
        return sol;
        
    }
}