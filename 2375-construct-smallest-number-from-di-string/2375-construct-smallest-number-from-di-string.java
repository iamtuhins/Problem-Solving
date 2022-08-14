class Solution {
    public String smallestNumber(String pattern) {
        int n=pattern.length();
        StringBuilder sb=new StringBuilder();
        StringBuilder st=new StringBuilder();
        for(int i=0;i<=n;i++){
            st.append((char)('1'+i));
            if(i==n || pattern.charAt(i)=='I'){
                sb.append(st.reverse());
                st=new StringBuilder();
            }
        }
        String sol=sb.toString();
        return sol;
        
    }
}