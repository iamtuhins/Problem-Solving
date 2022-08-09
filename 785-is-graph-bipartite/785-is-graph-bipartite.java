class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int colorGraph[]=new int[n];
        for(int i=0;i<n;i++)
            colorGraph[i]=-1;
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
    boolean fn(int graph[][],int id,int arr[]){
        for(int num: graph[id]){
            if(arr[num]==-1){
                arr[num]=1-arr[id];
                boolean temp=fn(graph,num,arr);
                if(temp==false){
                    return false;
                }
            }else if(arr[num]==arr[id]){
                return false;
            }
        }
        return true;
    }
}