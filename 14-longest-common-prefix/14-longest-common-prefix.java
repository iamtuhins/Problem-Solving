class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        String sol="";
        if(n<1){
            return sol;
        }
        if(n==1){
            return strs[0];
        }
        int m=strs[0].length();
        for(int i=0;i<m;i++){
            char n1=strs[0].charAt(i);
            boolean match=true;;
            for(int j=1;j<n;j++){
                if(strs[j].length()<=i || strs[j].charAt(i)!=n1){
                    match=false;
                    break;
                }
            }
            if(match==false){
                break;
            }else{
                sol=sol+n1;
            }
        }
        return sol;
        
    }
}