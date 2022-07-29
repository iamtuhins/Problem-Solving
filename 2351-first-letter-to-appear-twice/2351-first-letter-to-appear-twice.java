class Solution {
    public char repeatedCharacter(String s) {
        int n=s.length();
        Set<Character>st=new HashSet<>();
        for(int i=0;i<n;i++){
            char temp=s.charAt(i);
            if(st.contains(temp)){
                return temp;
            }else{
                st.add(temp);
            }
        }
        char tm='m';
        return tm;
        
    }
}