class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int colorGraph[]=new int[n];
        Arrays.fill(colorGraph,-1);
        for(int i=0;i<n;i++){
            if(colorGraph[i]==-1){
                colorGraph[i]=1;
                boolean temp=fn(graph,i,colorGraph);
                if(temp==false){
                    return false;
                }
            }
        }
        return true;
    }
    boolean fn(int graph[][],int id,int []arr){
        for(int m: graph[id]){
            if(arr[m]==-1){
                arr[m]=1-arr[id];
                boolean tm=fn(graph,m,arr);
                if(tm==false){
                    return false;
                }
            }else if(arr[m]==arr[id]){
                return false;
            }
        }
        return true;
    }
}