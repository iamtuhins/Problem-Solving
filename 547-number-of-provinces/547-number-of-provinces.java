class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    adj.get(i+1).add(j+1);
                }
            }
        }
        int vist[]=new int[n+1];
        int sol=0;
        for(int i=1;i<=n;i++){
            if(vist[i]==0){
                sol++;
                fn(adj,vist,i);
            }
        }
        return sol;
        
        
    }
    void fn(List<List<Integer>>adj,int vist[],int id){
        vist[id]=1;
        for(int temp: adj.get(id)){
            if(vist[temp]==0){
                fn(adj,vist,temp);
            }
        }
    }
}