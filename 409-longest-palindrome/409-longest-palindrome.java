class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        int sol=0;
        Set<Character>st=new HashSet<>();
        for(int i=0;i<n;i++){
            char temp=s.charAt(i);
            if(st.contains(temp)){
                sol+=2;
                st.remove(temp);
            }else{
                st.add(temp);
            }
        }
        if(st.size()>0)
            sol+=1;
        return sol;
        
    }
}