class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int A[]=new int[n];
        int B[]=new int[n];
        Arrays.fill(A,Integer.MAX_VALUE);
        Arrays.fill(B,Integer.MAX_VALUE);
        fn(node1,A,edges);
        fn(node2,B,edges);
        int sol=-1;
        int topDist=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(A[i]==Integer.MAX_VALUE || B[i]==Integer.MAX_VALUE){
                continue;
            }
            if(topDist>Math.max(A[i],B[i])){
                topDist=Math.max(A[i],B[i]);
                sol=i;
            }
        }
        return sol;
        
        
        
        
    }
    void fn(int node,int dist[],int arr[]){
        dist[node]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int p=q.remove();
            int edgeNode=arr[p];
            if(edgeNode!=-1 && dist[edgeNode]==Integer.MAX_VALUE){
                q.add(edgeNode);
                dist[edgeNode]=dist[p]+1;
            }
        }
    }
}