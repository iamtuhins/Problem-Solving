class Solution {
    public int removePalindromeSub(String s) {
        int n=s.length();
        //All the String are either a or b
        if(palind(s,n-1)){
            return 1;
            //if full string in palindrom than it will take 1 rounds 
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