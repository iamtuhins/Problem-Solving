class Solution {
    public int appendCharacters(String s, String t) {
        int ids=s.length();
        int idt=t.length();
        int n=0;
        int m=0;
        while(n<ids && m<idt){
            char s1=s.charAt(n);
            char t1=t.charAt(m);
            if(s1==t1){
                n++;
                m++;
            }else{
                n++;
            }
        }
        if(m==t.length()){
            return 0;
        }
        int sol=(t.length()-m);
        return sol;
        
    }
}