class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int vist[]=new int[rooms.size()];
        dfs(rooms,vist,0);
        for(int i=0;i<vist.length;i++){
            if(vist[i]==0){
                System.out.println(i);
                return false;
            }
        }
        return true;
        
    }
    void dfs(List<List<Integer>>rm,int vist[],int m){
        vist[m]=1;
        for(int nums: rm.get(m)){
            if(vist[nums]==0){
                dfs(rm,vist,nums);
            }
        }
    }
}