class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int sol[]=new int[1];
        for(int i=0;i<n;i++){
            //For odd number palindroms
            isPaln(s,i,i,sol);
            //For Even number palindroms(aa is palindrom)
            isPaln(s,i,i+1,sol);
        }
        return sol[0];
        
    }
    void isPaln(String s,int left,int right,int sol[]){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            sol[0]++;
            left--;
            right++;
        }
        
    }
}