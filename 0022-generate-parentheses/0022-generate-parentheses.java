class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>sol=new ArrayList<>();
        String tm="";
        fn(n,sol,0,0,tm);
        return sol;
        
        
    }
  void fn(int n,List<String>sl,int fst,int sn,String temp){
        if(fst==n && sn==n){
            sl.add(temp);
            return;
        }
        if(fst<n){
            fn(n,sl,fst+1,sn,temp+"(");
        }
        if(n>sn && fst>sn){
            fn(n,sl,fst,sn+1,temp+")");
        }
    }
}