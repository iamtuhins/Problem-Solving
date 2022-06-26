class Solution {
    public int countAsterisks(String s) {
        int n=s.length();
        int sol=0;
        boolean fl=false;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*' && fl==false){
                sol++;
                //when pipe apppears first time stop count
                //when pipe apppears  for second time start count utill new pipe
            }else if(s.charAt(i)=='|'){
                fl=!fl;
            }
        }
        return sol;
        
    }
}