class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n=s.length();
        StringBuilder st=new StringBuilder();
        int m=t.length();
        for(int i=0;i<n;i++){
            char temp=s.charAt(i);
            if(temp=='#' && st.length()>0){
                st.deleteCharAt(st.length()-1);
            }else if(temp!='#'){
                st.append(temp);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            char temp=t.charAt(i);
            if(temp=='#' && sb.length()>0){
                sb.deleteCharAt(sb.length()-1);
            }else if(temp!='#'){
                sb.append(temp);
            }
        }
        String s1=st.toString();
        String s2=sb.toString();
        if(s1.equals(s2)){
            return true;
        }
        return false;
        
    }
}