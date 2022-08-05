class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(arr[i]==-1){
                arr[i]=1;
                boolean tm=fn(graph,i,arr);
                if(tm==false){
                    return false;
                }
            }
        }
        return true;
        
    }
    boolean fn(int graph[][],int i,int []arr){
        for(int nums: graph[i]){
            if(arr[nums]==-1){
                arr[nums]=1-arr[i];
                boolean tm=fn(graph,nums,arr);
                if(tm==false){
                    return false;
                }
            }else if(arr[nums]==arr[i]){
                return false;
            }
        }
        return true;
        
    }
}