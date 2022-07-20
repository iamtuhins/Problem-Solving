class Solution {
    public boolean canChange(String start, String target) {
        int n=target.length();
        if(n==0){
            return false;
        }
        if(start.replace("_","").equals(target.replace("_",""))==false){
            return false;
        }
           int m=0;
           int j=0;
           while(n>m && n>j){
               while(n>m && start.charAt(m)!='R'){
                   m++;
               }
               while(n>j && target.charAt(j)!='R'){
                   j++;
               }
               if(m>j){
                   return false;
               }
               m++;
               j++;
           }
           m=0;
           j=0;
           while(n>m && n>j){
               while(n>m && start.charAt(m)!='L'){
                   m++;
               }
               while(n>j && target.charAt(j)!='L'){
                   j++;
               }
               if(j>m){
                   return false;
               }
               m++;
               j++;
           }
           return true;
        
    }
}