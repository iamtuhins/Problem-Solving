class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m<n)
            return false;
        if(n==0)
            return true;
        int i=0,j=0;
        char val1=s.charAt(i);
        char val2=t.charAt(j);
        while(i<n && j<m){
            val1=s.charAt(i);
            val2=t.charAt(j);
            if(val1==val2){
                i++;
                j++;
            }else{
                while(j<m && t.charAt(j)!=val1){
                    j++;
                }
                if(j>=m)
                    return false;
            }
        }
        if(i<n)
            return false;
        return true;
        
    }
}