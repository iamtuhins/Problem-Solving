class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>sol=new ArrayList<>();
        String tem="";
        fn(sol,tem,0,0,n);
        return sol;
        
    }
    void fn(List<String>sol,String st,int fst,int snd,int n){
        if(fst==n && snd==n){
            sol.add(st);
            return;
        }
        if(fst<n){
            fn(sol,st+"(",fst+1,snd,n);
        }
        if(snd<n && fst>snd){
            fn(sol,st+")",fst,snd+1,n);
        }
    }
}