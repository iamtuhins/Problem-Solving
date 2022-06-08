class Solution {
    public int removePalindromeSub(String s) {
        int n=s.length();
        if(palind(s,n-1)){
            return 1;
        }
        return 2;
        
    }
    boolean palind(String st,int n){
        int m=0;
        while(m<=n){
            if(st.charAt(m)!=st.charAt(n)){
                return false;
            }
            m++;
            n--;
        }
        return true;
    }
}