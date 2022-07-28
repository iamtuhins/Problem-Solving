class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer>q=new LinkedList<>();
        int n=rooms.size();
        q.add(0);
        int vist[]=new int[n];
        while(!q.isEmpty()){
            int temp=q.remove();
            vist[temp]=1;
            for(int ng: rooms.get(temp)){
                if(vist[ng]==0){
                    q.add(ng);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(vist[i]==0){
                return false;
            }
        }
        return true;
    }
}