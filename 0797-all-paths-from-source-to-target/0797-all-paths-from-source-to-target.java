class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        List<List<Integer>>sol=new ArrayList<>();
        List<Integer>mn=new ArrayList<>();
        fn(sol,graph,0,mn);
        return sol;
        
        
    }
    void fn(List<List<Integer>>sol,int gp[][],int n,List<Integer>mn){
        if(n==gp.length-1){
            mn.add(n);
            sol.add(new ArrayList<Integer>(mn));
            return;
        }
        mn.add(n);
        for(int temp: gp[n]){
            fn(sol,gp,temp,new ArrayList<Integer>(mn));
        }
    }
}