class Solution {
    public String getHint(String secret, String guess) {
        int sArr[]=new int[10];
        int gArr[]=new int[10];
        int n=guess.length();
        int bull=0;
        int cow=0;
        for(int i=0;i<n;i++){
            int stemp=secret.charAt(i)-'0';
            int gtemp=guess.charAt(i)-'0';
            if(stemp==gtemp){
                bull++;
            }else{
                sArr[stemp]++;
                gArr[gtemp]++;
                if(sArr[gtemp]>0){
                    sArr[gtemp]--;
                    gArr[gtemp]--;
                    cow++;
                }
                if(gArr[stemp]>0){
                    gArr[stemp]--;
                    sArr[stemp]--;
                    cow++;
                }
            }
        }
        StringBuilder st=new StringBuilder();
        st.append(bull);
        st.append('A');
        st.append(cow);
        st.append('B');
        String sol=st.toString();
        return sol;
    }
}